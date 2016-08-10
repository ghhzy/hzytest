package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class maptolist {

	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		Set set = map.entrySet();
//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//		Collection<Map<String,Object>> con = (Collection<Map<String,Object>>)set;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>((Collection)set);
//		List<Map<String,Object>> list = (ArrayList)((Collection)set);
		System.out.println(list);
	}

}
