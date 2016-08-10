package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DateTimeSplit {

	public static void main(String[] args) {
		getTimeYMD(new Date());
	}
	
	/**
	 * 获取当前日期的年月日时分秒
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 */
	public static Map<String,String> getTimeYMD(Date date){
	   Map<String,String> map=new HashMap<String,String>(); 
	   if(date!=null){
		   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		   try {
			   
			  String time =  df.format(date);
			  System.out.println(time);
			  String[] timesp = time.split("-");
			  System.out.println(timesp);
			  map.put("year", timesp[0]);
			  map.put("month", timesp[1]);
			  map.put("day", timesp[2]);
			  map.put("hour", timesp[3]);
			  map.put("min", timesp[4]);
			  map.put("sec", timesp[5]);
			  System.out.println(map);
			  /*Date date1 = df.parse(date);
				   long l=date1.getTime()-date2.getTime();
				   
				   long day=l/(24*60*60*1000);
				   long hour=(l/(60*60*1000)-day*24);
				   long min=((l/(60*1000))-day*24*60-hour*60);
				   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
				   
				   map.put("day", day+"");
				   map.put("hour", hour+"");
				   map.put("min", min+"");
				   map.put("s", s+"");*/
			} catch (Exception e) {
			}
	   }
	   return map;
   }

}
