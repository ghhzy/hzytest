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
     * ��ȡϵͳ����ʱ��
     * @return: ���ص�ʱ���ʽ��:2010-02-23 15:10:33
     */
    public static String toLocaleString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
    
    /**
     * ��ȡϵͳ����ʱ��
     * @return: ���ص�ʱ���ʽ��:2010-02-23
     */
    public static String getCurSimpleDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
    /**
     * ��ȡϵͳ����ʱ��
     * @return: ���ص�ʱ���ʽ��:2010��02��23��
     */
    public static String _getCurSimpleDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd��");
        return df.format(new Date());
    }
    
    
    /**
     * ��ȡϵͳ����ʱ��
     * @return: ���ص�ʱ���ʽ��:2010-02-23 15:10:33
     */
    public static Date getCurrentDate() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }  
    
    /**
     * @author hzy
     * @category ��ʽ��ʱ��,һ�����ڱȶ� ����ʱ��
     */
    public static String getStrHHmm(Date date) {
    	if(date==null){
    		return null;
    	}
    	SimpleDateFormat df = new SimpleDateFormat("HH:mm");//�������ڸ�ʽ
    	return df.format(date);
    }    
    
    /**
     * @author hzy
     * @category ��ʽ��ʱ��,һ�����ڱȶ�
     */
    public static Date getDateHHmm(String date) {
    	if(date==null){
    		return null;
    	}
    	SimpleDateFormat df = new SimpleDateFormat("HH:mm");//�������ڸ�ʽ
    	try {
    		return df.parse(date);
    	} catch (ParseException e) {
    		e.printStackTrace();
    		return null;
    	}
    }    
   
    /**
     * ��ȡ��ǰʱ�����
     * @return
     */
    public static int getCorrentYear(){
    	int y = Calendar.getInstance().get(Calendar.YEAR);
    	return y;
    }
    
	
    /**
     * ת��ʱ���ʽ��yyyy-MM-dd HH:mm:ssתyyyy-MM-dd
     * @return: ���ص�ʱ���ʽ��:2010-02-23
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
     * ת��ʱ���ʽ��yyyy-MM-dd HH:mm:ssתyyyy-MM-dd
     * @return: ���ص�ʱ���ʽ��:2010-02-23
     */
	public static Date foramtDateToDate(String strDate) {
		Date date = null;
		try {
			if (strDate != null&&strDate.length() >= 10) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
				String str = strDate.substring(0,10);
				date=df.parse(str);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	/**
	 * ת��ʱ���ʽ��yyyy-MM-dd תyyyy/MMdd
	 * @param strDate
	 * @return
	 */
	public static Date formateDate(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//�������ڸ�ʽ
			date=df.parse(strDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}
	
	/**
     * ��ȡϵͳ����ʱ��
     * @return: ���ص�ʱ���ʽ��:2010-02-23 15:10:33
     */
    public static Date getCurrentDates() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");//�������ڸ�ʽ
		try {
			return df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    /**
     * ��ȡϵͳ����ʱ��
     * @return: ���ص�ʱ���ʽ��:2010-02-23
     */
    public static Date getCurDate() {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
    	try {
    		return df.parse(df.format(new Date()));
    	} catch (ParseException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
	
	/**
	 * ��ȡ ��������ʱ���(�� �죬Сʱ�����ӣ��� ����map�з���)
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
				   ///System.out.println(""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");
			} catch (ParseException e) {
				e.printStackTrace();
			}
	   }
	   return map;
   }
	/**
	 *  ��ȡ ��������  ��� Сʱ��
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
	 * ʱ���ʽ��   yyyy-MM-dd
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
	 * ��  ���� ת��Ϊ   ��ʱ:��:�롱  �ĸ�ʽ
	 * @param seconds ������
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
	 * ���ݿ�ʱ�䴦��
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
	 * ���ݿ�ʱ�䴦��
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
	 * ʱ��ת�� ������תΪ yyyy-MM-dd(2014-10-10)
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
	
	//���һ��ǰ������
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
	
	//���allMonth��ǰ�����ڣ�allMonth����Ϊ����ֵ
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
	 * ת��ʱ���ʽ��yyyy-MM-dd
	 * @param strDate
	 * @return
	 */
	public static Date strformateDate(String strDate) {
		Date date = null;
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
			date=df.parse(strDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return date;
	}	
	 /**
     * ת��ʱ���ʽ��yyyy-MM-dd HH:mm:ss
     * @return: ���ص�ʱ���ʽ��:2010-02-23
     */
	public static Date formatToFullDate(String strDate) {
		Date date = null;
		if(strDate==null){
			return date;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			date=df.parse(strDate);
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		return date;
	}
	
	/**
	 * stringתTimestamp
	 * @param tsStr ����Ϊ"2011-05-09 11:49:45"��ʽ
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
     * �������ڻ�ȡ���ڼ�
     * @param newtime
     * @return
     */
	public static String testDate(String newtime) {
		String dayNames[] = {"������","����һ","���ڶ�","������","������","������","������"};
		Calendar c = Calendar.getInstance();// ���һ��������ʵ��
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
