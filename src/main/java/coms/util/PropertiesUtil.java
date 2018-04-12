package coms.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class  PropertiesUtil {
	
	Properties properties ;
	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public PropertiesUtil(){
		properties = new Properties();
		BufferedReader bufferedReader = null;
		try {
			String path = this.getClass().getResource(".").getPath();
			System.out.println(path);
			path = path.substring(0, path.length()-1);
			path = path.replace("util", "");
			path = path.substring(0, path.length()-1);
			path = path.replace("coms", "");
			path = path.substring(1, path.length());
			path = path +"config.properties";
			bufferedReader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(bufferedReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		  
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getValue(String key){
		return properties.getProperty(key);
	}

}
