package execution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverconfig.DriverFactory;
import driverconfig.DriverFactory2;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks 
{
	WebDriver driver;
	// DriverFactory df;
	DriverFactory2 df;
	
	@Before
	public void launchBrowser() throws IOException
	{
		 Properties prop = new Properties();
			
	     // String path = System.getProperty("user.dir"); // project path
	        
	  String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
			
	     System.out.println(path);
	      
	     FileInputStream fis = new FileInputStream(path);
	        
	      prop.load(fis);
	          
	      String browsername = prop.getProperty("browser");
	      
	       String mavenBrowser = System.getProperty("clibrowser");
	       
	       System.out.println("Browser received from maven is :"+mavenBrowser);
	       
	       if(mavenBrowser!= null)
	       {
	    	   browsername = mavenBrowser;
	       }
		
		
		   // df = new DriverFactory();
	     
	       df = new DriverFactory2();
	       
		   driver = df.initBrowser(browsername);
		  
		  driver.manage().window().maximize();
	}
	
       @After (order = 1)
       public void quiteBrowser()
       {
    	   driver.quit();
       }
       
       @After (order = 2)
       public void tearDown( Scenario scenario)
       {
    	     boolean isFailed = scenario.isFailed();
    	  
    	     if(isFailed)
    	   {
    	   
    	   String scenarioName = scenario.getName();
    	   
    	   String name = scenarioName.replaceAll(" ", "_");
    	        
    	   TakesScreenshot ts = (TakesScreenshot)driver;
    	   
    	    byte[] source = ts.getScreenshotAs(OutputType.BYTES);
    	    
    	    scenario.attach(source, "image/png", name);
    	   }
    	       
       } 
       
       
       
}
