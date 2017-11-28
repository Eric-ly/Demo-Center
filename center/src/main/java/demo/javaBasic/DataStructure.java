package demo.javaBasic;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;

public class DataStructure
{

	public void list(){
		Vector<Integer> v1 = new Vector<Integer>();
		Integer in =new Integer(1);
		v1.addElement(in);
		
		LinkedList<Integer> linkedList =new LinkedList<Integer>();
		Integer inte = 5;
		int m = inte;
		
	}
	@Test
	public void dateTest(){
	Date date =new Date();
		System.out.println(date);
		System.out.println("年份：" + date.getYear());
		System.out.println("年份：" + date.getMonth());
		System.out.println(new Date(2017-1900, 5-1, 27));
		date.setHours(date.getHours()+1);
//		？
//		data 转换 全用long
		System.out.println("11"+date);
	long time = 1290876532190L;
		System.out.println(new Date(time));
	
//   SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE-MMMM-dd-yyyy");  
   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:MM:SS.SSS");  
   	System.out.println(date.getTime());
   	System.out.println("111"+dateFormat.format(date));   
   	
   	String strDate = null; 
   	strDate = DateFormat.getDateInstance().format(date);  
      System.out.println(strDate);        // Mar 2, 2012  
//      计算某一天是一年中的第几星期  
	Calendar cal=Calendar.getInstance();  
	cal.set(Calendar.YEAR, 2006);  
	cal.set(Calendar.MONTH, 8);  
	cal.set(Calendar.DAY_OF_MONTH, 3);  
	int weekno=cal.get(Calendar.WEEK_OF_YEAR);  
	
	
	}
}
