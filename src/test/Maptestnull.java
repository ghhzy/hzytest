package test;

import java.util.HashMap;
import java.util.Map;

public class Maptestnull {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map map = new HashMap();
		map.put(1, 2);
		map.put(2, map);
		map.remove(1);
		System.out.println(map);
		System.out.println(((Map)map.get(2)).get(1));
		
		
		/*
		Map map1 = new HashMap();
		map1.put(5, map);
		System.out.println(map1);
		map.put(1, 4);
		System.out.println(map1);*/

	}

}
