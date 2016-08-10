package test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;



public class Test {

	public int stringToInt(String classId) {
		return Integer.parseInt(classId);
	}
	
	 /**
		 * 将  秒数 转换为   “时:分:秒”  的格式
		 * @param seconds 总秒数
		 * @return
		 */
		public static String getFormatTimeLength(String seconds){
			String formatTime="";
			if(seconds!=null&&!seconds.isEmpty()){
				int secondLength=Integer.parseInt(seconds);
				String hour = new DecimalFormat("00").format(secondLength / 3600); 
				String minute = new DecimalFormat("00").format(secondLength % 3600 / 60); 
				String second = new DecimalFormat("00").format(secondLength % 60 );
				formatTime=hour+":"+minute+":"+second;
			}
			return formatTime;
		}
		
		/**
		 * 验证邮政编码
		 * 
		 * @param post
		 */
		public static boolean checkPost(String post) {
			boolean flag = false;
			try {
				
				Pattern regex = Pattern .compile("[a-zA-Z_0-9]{0,}");
				Matcher matcher = regex.matcher(post);
				flag = matcher.matches();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(">>>>>>>>:"+post+":"+flag);
			
			return flag;
		}
		
		
		public static Date lastDayOfMonth(Date date) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.set(Calendar.DAY_OF_MONTH, 1);
	        cal.roll(Calendar.DAY_OF_MONTH, -1);
	        return cal.getTime();
	    }
		
		public static  void getUUID(){
			for (int i = 0; i < 40; i++) {
				System.out.println(java.util.UUID.randomUUID().toString().toUpperCase());
			}
		}

		private int bbb;
		
		public  int getbbb(){
			return bbb;
		}
		
		private static double getAvgGrade(int totalGrade,int count){
			
			double totalGrade_double=totalGrade*1.0;
			
			double count_double=count*1.0;
			
			return new BigDecimal(totalGrade_double/count_double).setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
		private static double getAvgGrade11(int totalGrade,int count){
			
			double totalGrade_double=totalGrade*1.0;
			
			double count_double=count*1.0;
			
			return new BigDecimal(totalGrade_double/count_double).setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("");
		t1(s);
		System.out.println(s);
		
	}
	
	public static void t1(StringBuilder m){
		
		
	}
	
	
}
