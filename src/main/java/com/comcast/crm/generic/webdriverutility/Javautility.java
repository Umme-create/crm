package com.comcast.crm.generic.webdriverutility;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Javautility {
	
	public int getrandomnumber() {
		Random randomint=new Random ();
		int randomnum = randomint.nextInt(5000);
		return randomnum;
	}
	public String getsystemdateyyyyMMdd(){
		Date dateobj=new Date();
		
		SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd");
		String date = s1.format(dateobj);
		return date;
	}
	
	public String getrequireddateyyyymmdd(int days) {
		
		//Date dateobj=new Date();
		SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd");
		
		
		Calendar cal=s1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = s1.format(cal.getTime());
		return reqdate;
	}

}
