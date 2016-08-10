package test;

import java.io.File;

public class filetest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("D:\\project\\File\\px\\ywsjimport\\b4bb8506-5b87-4fb2-b526-1a8d951c36eb_BasPxJxal.xls");
		f.getName();
		String druuid  = f.getName().substring(0, f.getName().indexOf("_"));
		System.out.println(druuid);
		String entiyname  = f.getName().replace(druuid + "_" , "");
		entiyname = entiyname.substring(0, entiyname.indexOf("."));
		System.out.println(entiyname);
	}

}
