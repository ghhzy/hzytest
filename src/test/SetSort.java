package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



public class SetSort {
	
	public static void main(String[] args) {
		
		
		Map<Integer,Object> map = new HashMap();
		map.put(20362, "20362");
		map.put(20363, "20362");
		map.put(20382, "20382");
		map.put(20364, "20364");
		map.put(20384, "20384");
		map.put(20383, "20383");
		map.put(38837, "38837");
		//排序的TreeSet
		Set<Integer> set = new TreeSet<Integer>();
		set.addAll(map.keySet());
		System.out.println(set);
		//无序的HashSet,而且是乱序
		Set<Integer> set1 = new HashSet<Integer>();
		set1.addAll(map.keySet());
		System.out.println(set1);
		//放入时的顺序LinkedHashSet
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		System.out.println(map.keySet());
		set2.addAll(map.keySet());
		System.out.println(set2);
		
		
		
		
		
		
		
	}
	
	
}
