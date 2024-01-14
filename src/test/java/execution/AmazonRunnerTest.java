package execution;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src\\test\\resources\\execution"},
		glue = {"execution"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		// tags = "@sanity"
		 
		
		)
public class AmazonRunnerTest extends AbstractTestNGCucumberTests {
	
	// writing data provider for parallel execution
	
	@DataProvider (parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
		
		//super – used to call parent class method
		
	}
	
	

}
 