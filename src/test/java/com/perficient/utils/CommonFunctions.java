package com.perficient.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonFunctions {
	
	public String readProperties(String propname){
		
		Properties prop = new Properties();
		FileInputStream input = null;
		String propvalue = null;

		try{
			
		input = new FileInputStream("src/test/java/com/perficient/utils/Config.properties");
		prop.load(input);
		propvalue = prop.getProperty(propname);
		return propvalue;
			
		}catch(IOException ie){
			ie.printStackTrace();		
		}
	
		return propvalue;
	}

}
