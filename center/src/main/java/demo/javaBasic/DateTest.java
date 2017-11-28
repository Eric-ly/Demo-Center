package demo.javaBasic;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest
{
	@Test
	public void dateTest(){
	   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:SS.SSS");  

		Date time =new Date();
		System.out.println("time :"+time);
//		System.out.println("年份：" + time.getYear());
//		System.out.println(new Date(2017-1900, 5-1, 27));
//		data 转换 全用long
		Long datetemp = time.getTime();
		datetemp = datetemp+ new Long(30*60*1000);
		time =new Date(datetemp);
		System.out.println("time + 30 min default :"+time);
//		date 自定义格式
	   System.out.println("time + 30 min format  ："+dateFormat.format(time)); 
	   System.out.println(time);
	   DateFormat.getDateInstance().clone();
   	String strDate = null; 
   	strDate = DateFormat.getDateInstance().format(time);  
      System.out.println(strDate);        // Mar 2, 2012  
//      计算某一天是一年中的第几星期  
	Calendar cal=Calendar.getInstance();  
	cal.set(Calendar.YEAR, 2017);  
	cal.set(Calendar.MONTH, 8);  
	cal.set(Calendar.DAY_OF_MONTH, 3);  
	int weekno=cal.get(Calendar.WEEK_OF_YEAR); 
	cal.setTime(new Date());
	System.out.println(weekno);
	System.out.println(cal.getTime());
	cal.add(Calendar.DAY_OF_MONTH, 1);;
	System.out.println(cal.getTime());
	}
}
	
