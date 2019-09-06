package com.wallethub.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreSuper {
	
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;
	
	public CoreSuper(){
		try {		
		File file = new File("C:\\Users\\Nani\\eclipse-workspace\\com.assignment.qa\\src\\main\\java\\com\\wallethub\\config\\config.properties");
		FileInputStream fip = new FileInputStream(file);
		prop = new Properties();
		prop.load(fip);
		}
		catch(FileNotFoundException e) {
		e.printStackTrace();	
		}
		catch(IOException e1) {
			e1.printStackTrace();	
		}	
	}
	
	public void initialize() {
		String browser= prop.getProperty("browser");
		 if(browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nani\\eclipse-workspace\\com.assignment.qa\\src\\test\\resources\\drivers\\chromedriver.exe");
			  driver= new ChromeDriver(); 
		 }
		 else if(browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nani\\eclipse-workspace\\com.assignment.qa\\src\\test\\resources\\drivers\\geckodriver.exe");
			  driver= new FirefoxDriver(); 
		 }
		 
		 driver.manage().deleteAllCookies();
		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 
		 
	}
	

}
