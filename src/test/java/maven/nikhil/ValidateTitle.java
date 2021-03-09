package maven.nikhil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Base64;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Central;

public class ValidateTitle extends Central{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Central.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("driver is navigated to home page");
	}
	@Test
	
	public void basePageNavigation() throws IOException {
		
	
	LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");//using assertion we are checking the actual text with expected text
	
		log.info("successfull");
	}
	 @AfterTest
	   public void teardown() {
		   driver.close();
	 }

}
