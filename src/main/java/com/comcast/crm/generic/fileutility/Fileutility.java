package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Fileutility {

	public String getdatafrompropertiesfile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./configAppdata/commondata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		
		
		return data;
	}
}
