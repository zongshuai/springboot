package cn.zshuai.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.zshuai.dao.CovJsonMapper;
import cn.zshuai.dao.ExinfoMapper;
import cn.zshuai.dao.TaskMapper;
import cn.zshuai.entity.CovJson;
import cn.zshuai.entity.CovJsonExample;
import cn.zshuai.entity.CovJsonExample.Criteria;
import cn.zshuai.entity.Exinfo;
import cn.zshuai.entity.Task;
import cn.zshuai.utils.ExtractUtils;
import cn.zshuai.utils.JsonUtils;
import cn.zshuai.utils.SFTPUtil;
import cn.zshuai.utils.shellUtils;

/**
 * Title: ReceiveSMS Description:接收到平台发送来的消息进行相应的处理
 * 
 * @author zshuai
 * @date Jul 18, 2019
 */
@Component
@Transactional
public class ReceiveSMS {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Environment env;

	@Autowired
	private CovJsonMapper cove;
	
	@Autowired
	private TaskMapper task;
	
	@Autowired
	private ExinfoMapper exinfo;

	@JmsListener(destination = ("${mq.revename}"))
	public void readMessage(String string) {
		// 1. 处理接收到的消息 暂定的消息格式： 检测任务ID+”@“+检测任务文件压缩包名字
		System.out.println("接收到的xgs队列的消息为" + string);
		String[] shell = string.split("@");
		String t_id = shell[0];
		String file_name = shell[1];
		String fileName = getFileName(file_name);// 解压后的文件名字
		// 2. 根据名字去本地获取文件，上传到所在服务器
		// 创建本地上传文件
		File file = new File(env.getProperty("upload_dir") + file_name);
		// 上传文件 参数注释：（dir:上传的目录 file:上传的文件 host:主机IP ）
		Boolean uploadFile = SFTPUtil.uploadFile(env.getProperty("ftp.upload_path"), file, env.getProperty("ftp.host"),
				22, env.getProperty("ftp.username"), env.getProperty("ftp.password"));
		// 3. 文件解压到指定位置，
		// 解压文件 参数注释：（path:压缩包所在父目录 fileName:压缩包名字 decpath:文件解压的目标路径 host:主机IP ）
		Boolean remoteZipToFile = ExtractUtils.remoteZipToFile(env.getProperty("ftp.upload_path"), file_name,
				env.getProperty("ftp.unzip_path"), env.getProperty("ftp.host"), env.getProperty("ftp.username"),
				env.getProperty("ftp.password"));

		if (uploadFile && remoteZipToFile) {
			shellUtils.transferShell(env.getProperty("ftp.shellpath"),
			env.getProperty("ftp.path") + fileName, env.getProperty("ftp.shellName"),
			env.getProperty("ftp.host"), env.getProperty("ftp.username"),
			env.getProperty("ftp.password"));
			
			System.out.println("开始执行脚本了");
		}
		// 4 .将生成的json文件远程拉取下来，存到本地，进行解析
		// 测试
		Long str = new Date().getTime();
		Boolean downloadJson = SFTPUtil.download(env.getProperty("ftp.unzip_path") + fileName, env.getProperty("ftp.jsonName"), env.getProperty("save_path"),
		env.getProperty("ftp.host"), 22, env.getProperty("ftp.username"),
		env.getProperty("ftp.password"));
		/*Boolean downloadJson = SFTPUtil.download(env.getProperty("ftp.unzip_path"), env.getProperty("ftp.jsonName"),
				env.getProperty("save_path") + str + ".json", env.getProperty("ftp.host"), 22,
				env.getProperty("ftp.username"), env.getProperty("ftp.password"));*/
		// 解析存入数据库
		if (downloadJson) {
			System.out.println("下载成功!");
			String readJsonFile = JsonUtils.readJsonFile(env.getProperty("save_path") + str + ".json");
			JSONObject jobj = JSON.parseObject(readJsonFile);
			// System.out.println(jobj.get("issueInfo").toString());
			JSONArray links = jobj.getJSONArray("issueInfo");
			CovJson cov_pojo = new CovJson();
			for (int i = 0; i < links.size(); i++) {
			//for (int i = 0; i < 3; i++) {
				JSONObject pojo = (JSONObject) links.get(i);
				cov_pojo.setCid((Integer) pojo.get("cid"));
				// 获取occurrences对应的JSONArray的值
				JSONArray entity = (JSONArray) pojo.get("occurrences");
				// 转化为map，后面通过key获取值
				Map map = (Map) entity.get(0);
				cov_pojo.setChecker((map.get("checker") != null) ? map.get("checker") + "" : null);
				cov_pojo.setFile((map.get("file") != null) ? map.get("file") + "" : null);
				cov_pojo.setFun((map.get("function") != null) ? map.get("function") + "" : null);
				cov_pojo.setCategory((map.get("subcategory") != null) ? map.get("subcategory") + "" : null);
				cov_pojo.setEln((map.get("mainEventLineNumber") != null) ? map.get("mainEventLineNumber") + "" : null);
				//cov_pojo.setEdn( (map.get("mainEventDescription") != null) ? map.get("mainEventDescription") + "" : null);
				cov_pojo.setEdn("null");
				cov_pojo.setComName((map.get("componentName") != null) ? map.get("componentName") + "" : null);
				cov_pojo.setTid(1);
				cov_pojo.setTag(str + "");
				cove.insert(cov_pojo);
			}
		}
		// 5. 生成Excel表格，表格名字用时间戳来区分，然后真实名字以及对应关系写入那个专门的Excel_info表中
		//a. 生成EXCEL并指定输出路径
		try {
			CovJsonExample example = new CovJsonExample();
			Criteria criteria = example.createCriteria();
			criteria.andTidEqualTo(Integer.valueOf(t_id));
			criteria.andTagEqualTo(str+"");
			List<CovJson> entityList = cove.selectByExample(example);
			OutputStream out = new FileOutputStream( env.getProperty("excel_save_path")+str+".xlsx");
			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
			// 设置SHEET
			Sheet sheet = new Sheet(1, 0);
			sheet.setSheetName("sheet1");
			// 设置标题
			Table table = new Table(1);
			List<List<String>> titles = new ArrayList<List<String>>();
			titles.add(Arrays.asList("CID"));
			titles.add(Arrays.asList("类别"));
			titles.add(Arrays.asList("文件"));
			titles.add(Arrays.asList("函数"));
			table.setHead(titles);

			// 查询数据导出即可 比如说一次性总共查询出100条数据
			List<List<String>> rowList = new ArrayList<>();
			for (CovJson covJson : entityList) {
				rowList.add(Arrays.asList(covJson.getCid()+"",covJson.getChecker(),covJson.getFile(),covJson.getFun()));
			}
			writer.write0(rowList, sheet, table);
			writer.finish();
			//b. 修改对应的数据库数据
			//存入exinfo表格
			Exinfo pojo = new Exinfo();
			pojo.setTid(Integer.valueOf(t_id));
			pojo.setOname(str+".xlsx");
			pojo.setNname(fileName+".xlsx");
			pojo.setPath(env.getProperty("excel_save_path")+str+".xlsx");
			pojo.setTime(new Date());
			pojo.setTag("4");
			exinfo.insert(pojo);
			//修改对应的task状态
			Task taskPojo = task.selectByPrimaryKey(Integer.valueOf(t_id));
			taskPojo.setDstatus(2);
			task.updateByPrimaryKeySelective(taskPojo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 6. 解析存储数据库完毕后，发送消息，暂定为一个标识位，代表是否成功，一个就是检测的ID还有当前时间戳。发送个pojo吧。
		// jmsMessagingTemplate.convertAndSend(env.getProperty("mq.sendname"), "123");
		System.out.println("发消息了" + shell[0]);

	}

	// 静态方法 获取文件名字
	public static String getFileName(String originalFilename) {
		if (originalFilename.contains(".tar.gz")) {
			originalFilename = originalFilename.replace(".tar.gz", "");
		}
		if (originalFilename.contains(".tar.xz")) {
			originalFilename = originalFilename.replace(".tar.xz", "");
		}
		if (originalFilename.contains(".tar")) {
			originalFilename = originalFilename.replace(".tar", "");
		}
		return originalFilename;
	}
}
