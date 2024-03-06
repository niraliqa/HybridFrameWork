package com.Automation.Dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperty(String key)
	{
		Properties pro=new Properties();
		try {
			pro.load(new FileInputStream(new File("./Configuration/Config.properties")));
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found please check location "+ e.getMessage());
		} catch (IOException e) {
		
			System.out.println("Could not read the file "+e.getMessage());
		}
		
		String value=pro.getProperty(key);
		
		return value;
	}
	
}
