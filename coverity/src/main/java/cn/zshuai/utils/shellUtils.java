package cn.zshuai.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * @version: 1.0
 * @Description: 远程运行指定的脚本
 * @author: zshuai
 * @date: 2019年4月9日
 */
public class shellUtils {
	
	/**  
	 * <p>Title: transferShell</p>  
	 * <p>Description:远程调用服务器脚本进行代码检测 </p>  
	 * @param path ：需要检测的文件路径
	 * @param shellPath ：检测的脚本所在路径
	 * @param shellName  ：脚本名字
	 * @param host：主机IP
	 * @param username 用户名字
	 * @param password 密码
	 * @param string 
	 * @param date 调用时间
	 * @return  
	 */  
	public static String transferShell(String shellPath, String path, String shellName,String host,String username,String password) {
		try {
			Connection connection = new Connection(host);// 创建一个连接实例
			connection.connect();// Now connect
			boolean isAuthenticated = connection.authenticateWithPassword(username,password);// Authenticate
			if (isAuthenticated == false)
				throw new IOException("user and password error");
			Session sess = connection.openSession();// Create a session
			System.out.println("start exec command.......");
			sess.requestPTY("bash");
			sess.startShell();
			InputStream stdout = new StreamGobbler(sess.getStdout());
			InputStream stderr = new StreamGobbler(sess.getStderr());
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));
			PrintWriter out = new PrintWriter(sess.getStdin());
			out.println("cd "+shellPath);
			out.println("ll");
			//out.println("export FORCE_UNSAFE_CONFIGURE=1");
			//sh cov.sh /home/sims/2019OS/idir/+文件夹名字
			out.println("sh "+shellName +" "+path);//远程执行cov脚本   "/covdir/"+name
			out.println("ll");
			out.println("exit");
			System.out.println("退出了");
			out.close();
			sess.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 30000);
			System.out.println("下面是从stdout输出:");
			while (true) {
				String line = stdoutReader.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			System.out.println("下面是从stderr输出:");
			while (true) {
				String line = stderrReader.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			System.out.println("ExitCode: " + sess.getExitStatus());
			sess.close();/* Close this session */
			connection.close();/* Close the connection */
			System.out.println("到这里说明运行完毕");
			return null;
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(2);
			return null;
		}
		
	}
	
	public static String startShellCov(String path, String shellName,String host,String username,String password,String date ) {
		try {
			Connection connection = new Connection(host);// 创建一个连接实例
			connection.connect();// Now connect
			boolean isAuthenticated = connection.authenticateWithPassword(username,password);// Authenticate
			if (isAuthenticated == false)
				throw new IOException("user and password error");
			Session sess = connection.openSession();// Create a session
			System.out.println("start exec command.......");
			sess.requestPTY("bash");
			sess.startShell();
			InputStream stdout = new StreamGobbler(sess.getStdout());
			InputStream stderr = new StreamGobbler(sess.getStderr());
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));
			PrintWriter out = new PrintWriter(sess.getStdin());
			out.println("cd /home/sims/2019OS");
			out.println("ll");
			out.println("sh "+ shellName+" "+path+date);//远程执行cov脚本   "/covdir/"+name
			//out.println("sh aaa.sh " +date);//远程执行cov脚本   "/covdir/"+name
			System.out.println("sh "+ shellName+" "+path+date);
			out.println("ll");
			out.println("exit");
			System.out.println("退出了");
			out.close();
			sess.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 30000);
			System.out.println("下面是从stdout输出:");
			while (true) {
				String line = stdoutReader.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			System.out.println("下面是从stderr输出:");
			while (true) {
				String line = stderrReader.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			System.out.println("ExitCode: " + sess.getExitStatus());
			sess.close();/* Close this session */
			connection.close();/* Close the connection */
			System.out.println("到这里说明运行完毕");
			return null;
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(2);
			return null;
		}
		//System.out.println("到这里说明运行完毕");
		//return null;
		
	}

}
