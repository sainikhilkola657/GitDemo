package maven.nikhil;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Central;

public class validateNavigationBar extends Central {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Central.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		
	}
@Test
	
	public void basePageNavigation() throws IOException {
		
	
	
	LandingPage l=new LandingPage(driver);
     Assert.assertTrue(l.getNavigationBar().isDisplayed());	
}
@AfterTest
public void teardown() {
	   driver.close();
}

}
