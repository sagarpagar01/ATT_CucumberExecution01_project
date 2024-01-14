package driverconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverFactory {
	
	 static WebDriver driver;
         
	public WebDriver initBrowser(String browsername)
	{
		if (browsername.equalsIgnoreCase("Chrome"))
		{
			 driver = new ChromeDriver();
			
		}
		
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		return driver;	
	}
	
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	
	
	

}
