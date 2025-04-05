package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
	//create obj of Fis
	FileInputStream fis=new FileInputStream("./src\\test\\resources\\commonData.properties");
	
	//Create obj of property file
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	String BROWSER = prop.getProperty("browser");
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD );
	System.out.println(BROWSER );
	
	
	
		}

}
