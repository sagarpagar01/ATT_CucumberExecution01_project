package execution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Test {
	
	public static void main(String[] args) throws IOException 
	{
		
		
        Properties prop = new Properties();
		
        // String path = System.getProperty("user.dir"); // project path
        
        String path = System.getProperty("user.dir")+"\\src\\test\\resources\\execution\\config.properties";
		
        System.out.println(path);
        
        FileInputStream fis = new FileInputStream(path);
        
          prop.load(fis);
          
          String browsername = prop.getProperty("browser");
         
           System.out.println(browsername);
        
		
	}

}
