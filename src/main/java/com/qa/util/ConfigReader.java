package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	/**
	 * This method is used to load the properties from the config.properties file
	 * @return it returns Properties prop object
	 */

	public static Properties loadConfigProperties() {
		
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
public static Properties loadExtentProperties() {
		
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/extent.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
}

public static String getTestDocPath() {
	
	return new File("./src/test/resources/test.txt").getAbsolutePath();
}

}
