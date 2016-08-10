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
		// MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
		// ������������Ҫָ��useUnicode��characterEncoding
		// ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
		// �������֮ǰ��Ҫ�ȴ���javademo���ݿ�
		/*String url = "jdbc:mysql://192.168.10.222:3306/czj_data?"
				+ "user=root" +
				"&password=~!@Heluo" +
				"&useUnicode=true" +
				"&characterEncoding=UTF8";*/
		try {
			// ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
			// ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
			Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
			System.out.println("�ɹ�����MySQL��������");
			// һ��Connection����һ�����ݿ�����
			conn = DriverManager.getConnection(url);
			// Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			while (rs.next()) {
				Map<String,Object> map = new LinkedHashMap<String,Object>();
				int count = rs.getMetaData().getColumnCount();
				for(int i=1;i<=count;i++){
					map.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
//					System.out.println(map);
				}
				list.add(map);
//				System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3)+ "\t" + rs.getString(4)+ "\t" + AESUtil.decrypt(rs.getString(5), "~!@IOYN56465"));// ��������ص���int���Ϳ�����getInt()
		}
			return list;
		} catch (SQLException e) {
			System.out.println("MySQL��������");
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
		// MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
		// ������������Ҫָ��useUnicode��characterEncoding
		// ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
		// �������֮ǰ��Ҫ�ȴ���javademo���ݿ�
		String url = "jdbc:mysql://192.168.10.222:3306/hzy_ls_data?"
				+ "user=root" +
				"&password=~!@Heluo" +
				"&useUnicode=true" +
				"&characterEncoding=UTF8";
		try {
			// ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
			// ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
			Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
			System.out.println("�ɹ�����MySQL��������");
			// һ��Connection����һ�����ݿ�����
			conn = DriverManager.getConnection(url);
			// Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("MySQL��������");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}