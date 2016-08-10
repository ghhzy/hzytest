package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TestA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(readFile("C:/Users/hzy/Desktop/财政局学员信息1.txt").toString());

	}
	//G:/Heluo/Project/JAkaoqin/hot-deploy/JAkq/webapp/jinganassess/assess/ndkh/zwsz/tabel.html
	public static String getHtml(){
		try {
			StringBuffer html = new StringBuffer(); 
			java.net.URL url = new java.net.URL("http://www.baidu.com"); //根据 String 表示形式创建 URL 对象。
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();// 返回一个 URLConnection 对象，它表示到 URL 所引用的远程对象的连接。
			java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream());//返回从此打开的连接读取的输入流。
			java.io.BufferedReader br = new java.io.BufferedReader(isr);//创建一个使用默认大小输入缓冲区的缓冲字符输入流。

			String temp;
			while ((temp = br.readLine()) != null) { //按行读取输出流
			if(!temp.trim().equals("")){
			html.append(temp).append("\n"); //读完每行后换行
			}
			}
			br.close(); //关闭
			isr.close(); //关闭
			return html.toString(); //返回此序列中数据的字符串表示形式。
			} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
	}
	
	
	public static byte[] readFile(String filename) {

	    File file =new File(filename);
	    System.out.println(file.getPath());
	    if(filename==null || filename.equals(""))
	    {
	      throw new NullPointerException("无效的文件路径");
	    }
	    long len = file.length();
	    byte[] bytes = new byte[(int)len];
	    try {
	    	BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
	    	int r = bufferedInputStream.read( bytes );
			if (r != len)
			bufferedInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return bytes;

	}

}
