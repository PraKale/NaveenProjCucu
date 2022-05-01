package appliHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.DriverFactory.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driveFact;
	public WebDriver driver;
	private ConfigReader confiRead;
	Properties prop;
	
	@Before(order=0) 
	public void getProperty() {
		confiRead=new ConfigReader();
		prop=confiRead.init_prop();
	}
	
	@Before(order=1) 
		public void launchBrowser() {
			String bName=prop.getProperty("browser");
			driveFact=new DriverFactory();
			driver=driveFact.init_driver(bName);
		}
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order=1)
	public void takeScreenShot(Scenario sc) {
		if(sc.isFailed()) {
			//take screenshot
			String scName=sc.getName().replaceAll(" ", "_");
			byte[] source=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(source, "img/png", scName);
		}
	}
}
	

