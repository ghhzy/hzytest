package test;

import java.util.ArrayList;
import java.util.List;

public class HzyTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(list.toString());
//		String ss = list.toString().replaceAll("\\[-\\]", "");
		String ss = list.toString().replaceAll("[\\[\\]]", "");
		System.out.println(ss);
		// sb.toString() 就是你要的字符串;
		String mm = 
		ss.substring(0,ss.length()-2);
		System.out.println(mm);
	}

}
