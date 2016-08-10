package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MysqlDemo {
	public static void main(String[] args) throws Exception {
		
//		String sql = "SELECT name from hzyls";
		String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = 'czj_ofbiz'";
		
		String url = "jdbc:mysql://192.168.10.222:3306/czj_data?"
				+ "user=root" +
				"&password=~!@Heluo" +
				"&useUnicode=true" +
				"&characterEncoding=UTF8";
		
		List<Map<String,Object>> list = MysqlDemo.selectSql(url,sql);
		System.out.println(list);
		
		for(Map<String,Object> map : list){
			
			String tableName = (String)map.get("TABLE_NAME");
			String littleTableName = tableName.toLowerCase();
			String sqlStr = "INSERT INTO czj_ofbiz." + tableName + " SELECT * from hzy_ls_ofbiz."+littleTableName;
			insertSql(sqlStr);
		}
	}
	
	
	public static List<Map<String,Object>> selectSql(String url, String sql) throws Exception {
		Connection conn = null;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		// 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
		// 下面语句之前就要先创建javademo数据库
		/*String url = "jdbc:mysql://192.168.10.222:3306/czj_data?"
				+ "user=root" +
				"&password=~!@Heluo" +
				"&useUnicode=true" +
				"&characterEncoding=UTF8";*/
		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			while (rs.next()) {
				Map<String,Object> map = new LinkedHashMap<String,Object>();
				int count = rs.getMetaData().getColumnCount();
				for(int i=1;i<=count;i++){
					map.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
//					System.out.println(map);
				}
				list.add(map);
//				System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3)+ "\t" + rs.getString(4)+ "\t" + AESUtil.decrypt(rs.getString(5), "~!@IOYN56465"));// 入如果返回的是int类型可以用getInt()
		}
			return list;
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}
	
	
	public static void insertSql(String sql) throws Exception {
		Connection conn = null;
		// MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
		// 避免中文乱码要指定useUnicode和characterEncoding
		// 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
		// 下面语句之前就要先创建javademo数据库
		String url = "jdbc:mysql://192.168.10.222:3306/hzy_ls_data?"
				+ "user=root" +
				"&password=~!@Heluo" +
				"&useUnicode=true" +
				"&characterEncoding=UTF8";
		try {
			// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
			// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}