package com.power.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UtilDate {
 
	//得到传入时间的昨日开始与结束时间，上月的开始与结束时间
public static Map getDate(Calendar cal){
	
	cal.add(Calendar.DATE, -1);
	String yesterday = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	String startFix =  " 00:00:00";
	String endFix =  " 23:59:59";
	String start = yesterday+startFix;
	String end = yesterday +endFix;
	Calendar cal2 = Calendar.getInstance();
	
	String start2="";
	String end2 = "";
	int year = cal2.get(Calendar.YEAR);    //获取年
	int month = cal2.get(Calendar.MONTH);   //获取月份，0表示1月份
	if(month==0){
		year=year-1;
		month=12;
	}
	cal2.set(Calendar.MONTH, month-1);
	cal2.set(Calendar.DATE, 1);
	cal2.roll(Calendar.DATE, -1);
	int day = cal2.get(Calendar.DATE);    //获取当前天数
	start2=year+"-"+month+"-"+"01"+startFix;
	end2 = year+"-"+month+"-"+day+endFix;
	Map<String, Object> timeMap = new HashMap<String, Object>();
	timeMap.put("start", start);
	timeMap.put("end", end);
	timeMap.put("start2", start2);
	timeMap.put("end2", end2);

	return timeMap;
}
	

}
