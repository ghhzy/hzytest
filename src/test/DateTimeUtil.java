package test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DateTimeUtil {
	
	public static String dateFormatToString(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String time = "";
		try {
			time = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	
	public static String dateTimeToHHmm(Date date) {
		DateFormat format = new SimpleDateFormat("HH:mm");
		String time = "";
		if(date!=null)
			time = format.format(date);
		return time;
	}
	
	public static String dateTimeFormatToString(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String time = "";
		try {
			time = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	public static String dateTimeFormatToStringHHmm(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		String time = "";
		try {
			time = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	

	/**
     * 获取系统当期时间
     * @return: 返回的时间格式如:2010-02-23 15:10:33
     */
    public static String toLocaleString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
    
    /**
     * 获取系统当期时间
     * @return: 返回的时间格式如:2010-02-23
     */
    public static String getCurSimpleDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
    /**
     * 获取系统当期时间
     * @return: 返回的时间格式如:2010年02月23日
     */
    public static String _getCurSimpleDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        return df.format(new Date());
    }
    
    
    /**
     * 获取系统当期时间
     * @return: 返回的时间格式如:2010-02-23 15:10:33
     */
    public static Date getCurrentDate() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }  
    
    /**
     * @author hzy
     * @category 格式化时间,一般用于比对 返回时间
     */
    public static String getStrHHmm(Date date) {
    	if(date==null){
    		return null;
    	}
    	SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
    	return df.format(date);
    }    
    
    /**
     * @author hzy
     * @category 格式化时间,一般用于比对
     */
    public static Date getDateHHmm(String date) {
    	if(date==null){
    		return null;
    	}
    	SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
    	try {
    		return df.parse(date);
    	} catch (ParseException e) {
    		e.printStackTrace();
    		return null;
    	}
    }    
   
    /**
     * 获取当前时间的年
     * @return
     */
    public static int getCorrentYear(){
    	int y = Calendar.getInstance().get(Calendar.YEAR);
    	return y;
    }
    
	
    /**
     * 转换时间格式：yyyy-MM-dd HH:mm:ss转yyyy-MM-dd
     * @return: 返回的时间格式如:2010-02-23
     */
	public static String foramtDateToStr(String strDate) {
		try {
			if (strDate != null&&strDate.length() >= 10) {
				strDate = strDate.substring(0,9);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strDate;
	}
	/**
     * 转换时间格式：yyyy-MM-dd HH:mm:ss转yyyy-MM-dd
     * @return: 返回的时间格式如:2010-02-23
     */
	public static Date foramtDateToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null&&strDate.length() >= 10) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				String str = strDate.substring(0,10);
				date=df.parse(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	/**
	 * 转换时间格式：yyyy-MM-dd 转yyyy/MMdd
	 * @param strDate
	 * @return
	 */
	public static Date formateDate(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
			date=df.parse(strDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	/**
     * 获取系统当期时间
     * @return: 返回的时间格式如:2010-02-23 15:10:33
     */
    public static Date getCurrentDates() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//设置日期格式
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * 获取系统当期时间
     * @return: 返回的时间格式如:2010-02-23
     */
    public static Date getCurDate() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	try {
    		return df.parse(df.format(new Date()));
    	} catch (ParseException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
	
	/**
	 * 获取 两个日期时间差(将 天，小时，分钟，秒 放在map中返回)
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 */
	public static Map<String,String> getTimeDifference(String dateBegin,String dateEnd){
	   Map<String,String> map=new HashMap<String,String>(); 
	   if(dateBegin!=null&&!dateBegin.isEmpty()&&dateEnd!=null&&!dateEnd.isEmpty()){
		   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		   try {
				Date date1 = df.parse(dateEnd);
				Date date2 = df.parse(dateBegin);
				   long l=date1.getTime()-date2.getTime();
				   
				   long day=l/(24*60*60*1000);
				   long hour=(l/(60*60*1000)-day*24);
				   long min=((l/(60*1000))-day*24*60-hour*60);
				   long s=(l/1000-day*24*60*60-hour*60*60-min*60);
				   
				   map.put("day", day+"");
				   map.put("hour", hour+"");
				   map.put("min", min+"");
				   map.put("s", s+"");
				   ///System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
			} catch (ParseException e) {
				e.printStackTrace();
			}
	   }
	   return map;
   }
	/**
	 *  获取 两个日期  间隔 小时数
	 * @param dateBegin
	 * @param dateEnd
	 * @return
	 */
	public static String getTimeDifferenceToHour(String dateBegin,String dateEnd){
	   String timeDifference=null;
	   if(dateBegin!=null&&!dateBegin.isEmpty()&&dateEnd!=null&&!dateEnd.isEmpty()){
		   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   try {
				Date date1 = df.parse(dateEnd);
				Date date2 = df.parse(dateBegin);
				float l=date1.getTime()-date2.getTime();
				float timeDifferenceFloat=l/(60*60*1000);
				timeDifference=timeDifferenceFloat+"";
			} catch (ParseException e) {
				e.printStackTrace();
			}
	   }
	   return timeDifference;
   }
	
	
	/**
	 * 时间格式化   yyyy-MM-dd
	 * @param date
	 * @return
	 * fj
	 */
	public static String dateFormatdif(String date) {
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String time = "";
		try {
			time = format1.format(format1.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
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
	
	/**@author hzy
	 * @param
	 * 数据库时间处理
	 */
	public static String convert(Object o) {
		String result = o == null ? "" : o.toString();
		try {
			if (o instanceof Date) {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				result = format.format(o);
			}
		} catch (Exception e) {
			result = "";
		}
		return result;
	}
	
	/**@author hzy
	 * @param
	 * 数据库时间处理
	 */
	public static String convertToHasGTime(String date) {
		try {
			if(date==null||date.isEmpty()){
				return null;
			}
			DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
			Date dateNew = format1.parse(date);
			return format2.format(dateNew).toString();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 时间转换 把日期转为 yyyy-MM-dd(2014-10-10)
	 * @param object
	 * @return
	 */
	public static Object convertOfDate(Object object) {
		if (null == object || "".equals(object)) {
			return "";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (object instanceof Date) {
				object = sdf.format(object);
			} else if (object instanceof String) {
				object = sdf.format((Date)object);
			}
		} catch (Exception e) {
			return null;
		}
		return object;
	}
	
	//获得一周前的日期
	public static String lastWeek(){
		   Date date = new Date();
		   int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		   int month=Integer.parseInt(new SimpleDateFormat("MM").format(date));
		   int day=Integer.parseInt(new SimpleDateFormat("dd").format(date))-6;
		  
		   if(day<1){
		    month-=1;
		    if(month==0){
		     year-=1;month=12;
		    }
		    if(month==4||month==6||month==9||month==11){
		     day=30+day;
		    }else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
		    {
		     day=31+day;
		    }else if(month==2){
		     if(year%400==0||(year %4==0&&year%100!=0))day=29+day;
		     else day=28+day;
		    }     
		   }
		   String y = year+"";String m ="";String d ="";
		   if(month<10) m = "0"+month;
		   else m=month+"";
		   if(day<10) d = "0"+day;
		   else d = day+"";
		  
		   return y+"-"+m+"-"+d;
	}
	
	//获得allMonth月前的日期，allMonth可以为任意值
	public static String lastMonth(int allMonth) {
        Date date = new Date();
           int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
           int month=Integer.parseInt(new SimpleDateFormat("MM").format(date))-allMonth;
           int day=Integer.parseInt(new SimpleDateFormat("dd").format(date));
           if(month <= 0){
               int yearFlag = (month*(-1))/12 + 1;
               int monthFlag = (month *(-1))%12;
               year -= yearFlag;
               month=monthFlag*(-1) +12;
           }
           else if(day>28){
               if(month==2){
                   if(year%400==0||(year %4==0&&year%100!=0)){
                       day=29;
                   }else day=28;
               }else if((month==4||month==6||month==9||month==11)&&day==31){
                   day=30;
               }
           }
           String y = year+"";String m ="";String d ="";
           if(month<10) m = "0"+month;
           else m=month+"";
           if(day<10) d = "0"+day;
           else d = day+"";
          
           return y+"-"+m+"-"+d;
    }
	/**
	 * 转换时间格式：yyyy-MM-dd
	 * @param strDate
	 * @return
	 */
	public static Date strformateDate(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			date=df.parse(strDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}	
	 /**
     * 转换时间格式：yyyy-MM-dd HH:mm:ss
     * @return: 返回的时间格式如:2010-02-23
     */
	public static Date formatToFullDate(String strDate) {
		Date date = null;
		if(strDate==null){
			return date;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			date=df.parse(strDate);
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return date;
	}
	
	/**
	 * string转Timestamp
	 * @param tsStr 必须为"2011-05-09 11:49:45"格式
	 * @return
	 */
	public static Timestamp strConvertTimestamp(String tsStr) {
		 Timestamp ts = new Timestamp(System.currentTimeMillis());   
         try {   
             ts = Timestamp.valueOf(tsStr);   
             System.out.println(ts);   
         } catch (Exception e) {   
             e.printStackTrace();   
         }  
         return ts;
	}
	
    
    
    
    /**
     * 根据日期获取星期几
     * @param newtime
     * @return
     */
	public static String testDate(String newtime) {
		String dayNames[] = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar c = Calendar.getInstance();// 获得一个日历的实例
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		c.setTime(sdf.parse(newtime));
		} catch (ParseException e) {
		e.printStackTrace();
		}
		return dayNames[c.get(Calendar.DAY_OF_WEEK)-1];
	}
   

	public static Timestamp str2Timestamp(String str) {
		  if(null != str && !"".equals(str)){
		    Date date = str2Date(str, "yyyy-MM-dd HH:mm:ss");
		    return new Timestamp(date.getTime());
		  }
		  return null;
	} 
	 public static Date str2Date(String str, String format){
		  if (null != str && !"".equals(str)) {
		    SimpleDateFormat sdf = new SimpleDateFormat(format);
		    Date date = null;
		    try {
		     date = sdf.parse(str);
		     return date;
		   } catch (ParseException e) {
		     e.printStackTrace();
		  }
		}
		return null;
	}
	 public static String timestamp2Str(Timestamp time) {
		  if(null != time && !"".equals(time)){
		    Date date = new Date(time.getTime());
		    return date2Str(date,"yyyy-MM-dd HH:mm:ss");
		  }
		  return null;
	}
	 public static String date2Str(Date date, String format) {
		  if (null != date && !"".equals(date)) {
		    SimpleDateFormat sdf = new SimpleDateFormat(format);
		    return sdf.format(date);
		  }
		  return null;
	}
    public static  Timestamp getCurTimestamp(){
    	return new java.sql.Timestamp((new Date()).getTime());
    }
}
