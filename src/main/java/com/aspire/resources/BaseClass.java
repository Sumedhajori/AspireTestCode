package com.aspire.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop1; 
	public Properties prop2; 
	
	String path = System.getProperty("user.dir");
	
	
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException{
		
		prop1 = new Properties();
		FileInputStream fis1 = new FileInputStream(path+"\\src\\main\\java\\com\\aspire\\resources\\Config.properties");
		prop1.load(fis1);
		
		prop2 = new Properties();
		FileInputStream fis2 = new FileInputStream(path+"\\src\\main\\java\\com\\aspire\\resources\\Data.properties");
		prop2.load(fis2);
		
		String browserName = prop1.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\com\\aspire\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

	
}
