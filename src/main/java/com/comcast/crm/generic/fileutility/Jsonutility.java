package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Jsonutility {

	public String getdatafromjsonfile(String key) throws Throwable {
		FileReader fr=new FileReader("./configAppdata/appcommondata.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject map=(JSONObject)obj;
		String data =  map.get(key).toString();
		return data;
		
		
	}
}
