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
 * @Description: 远程解压缩指定目录下的指定名字的文件
 * @author: zshuai
 * @date: 2019年4月9日
 */
public class ExtractUtils {

	/*
	 * @Description:远程解压缩指定目录下的指定名字的文件
	 * @param path:指定解压文件的目录
	 * @param fileName:需要解压的文件名字
	 * @param decpath :解压完成后的存放路径
	 */
	public static Boolean remoteZipToFile(String path, String fileName , String decpath,String host,String username,String password) {
		Boolean result =false;
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
			out.println("cd " + path );
			out.println("ll");
			// out.println("unzip -o " + fileName + "  -d /" + decpath + "/");//解压zip格式
			out.println("tar xvf " + fileName + "  -C " + decpath );//解压tar格式
			out.println("ll");
			out.println("exit");
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
			result = true;
		} catch (IOException e) {
			e.printStackTrace(System.err);
			result =false;
			System.exit(2);
		}
		return result;
		
	}

}
