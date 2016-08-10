package test;

import java.util.HashMap;
import java.util.Map;

public class maptest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<Integer,Object> map = new HashMap<Integer,Object>();
		map.put(1, 2);
		map.remove(2);
		System.out.println(map);

	}

}
