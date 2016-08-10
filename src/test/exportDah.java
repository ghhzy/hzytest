package test;

import java.util.List;
import java.util.Map;


public class exportDah {

	
    
    public static void main(String[] args) throws Exception {
    	String sql = "SELECT dha h1,dha h2,A0101,A0177 from a0 order by dha DESC";
    	
    	String url = "jdbc:mysql://192.168.200.4:3306/czj_data?"
				+ "user=root" +
				"&password=root" +
				"&useUnicode=true" +
				"&characterEncoding=UTF8";
    	
		List<Map<String,Object>> list = MysqlDemo.selectSql(url,sql);
		System.out.println(list);
		//身份证解密
		for(Map<String,Object> m : list){
			m.put("A0177", AESUtil.decrypt((String)m.get("A0177"), "~!@IOYN56465"));
		}
		CSVUtil.WriteCSV(list);
	}
	
	
	
	    

}
