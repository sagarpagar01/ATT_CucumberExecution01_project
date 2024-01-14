package driverconfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverFactory2 {

	// for parallel execution
	
      public WebDriver  driver;
    
     public static  ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();

    @Before
    public WebDriver initBrowser(String browsername)
    {
      	if (browsername.equalsIgnoreCase("chrome"))
	{
		//driver = new ChromeDriver();
		
		tlDriver.set(new ChromeDriver()); 
		
	}
	else if (browsername.equalsIgnoreCase("firefox"))
	{
		 // driver = new FirefoxDriver();
		
		tlDriver.set(new FirefoxDriver());
	}
	
	return  getDriver();  // it will return synchronized locked driver
}


      @After
      public  static synchronized WebDriver getDriver()
     {
	       //return driver;
	
	       return tlDriver.get();
     }

}
