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
		
		System.out.println(readFile("C:/Users/hzy/Desktop/������ѧԱ��Ϣ1.txt").toString());

	}
	//G:/Heluo/Project/JAkaoqin/hot-deploy/JAkq/webapp/jinganassess/assess/ndkh/zwsz/tabel.html
	public static String getHtml(){
		try {
			StringBuffer html = new StringBuffer(); 
			java.net.URL url = new java.net.URL("http://www.baidu.com"); //���� String ��ʾ��ʽ���� URL ����
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();// ����һ�� URLConnection ��������ʾ�� URL �����õ�Զ�̶�������ӡ�
			java.io.InputStreamReader isr = new java.io.InputStreamReader(conn.getInputStream());//���شӴ˴򿪵����Ӷ�ȡ����������
			java.io.BufferedReader br = new java.io.BufferedReader(isr);//����һ��ʹ��Ĭ�ϴ�С���뻺�����Ļ����ַ���������

			String temp;
			while ((temp = br.readLine()) != null) { //���ж�ȡ�����
			if(!temp.trim().equals("")){
			html.append(temp).append("\n"); //����ÿ�к���
			}
			}
			br.close(); //�ر�
			isr.close(); //�ر�
			return html.toString(); //���ش����������ݵ��ַ�����ʾ��ʽ��
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
	      throw new NullPointerException("��Ч���ļ�·��");
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
