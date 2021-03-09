package maven.nikhil;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Central;

public class HomePage extends Central {
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Central.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password) throws IOException {
		driver.get(prop.getProperty("url"));
	
	LandingPage l=new LandingPage(driver); //creating the object of landing page to invoke those methods
	l.getLogin().click();
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(username);
	lp.getPassword().sendKeys(password);
	lp.getLogin().click();
	ForgotPassword fp=lp.forgotPassword();
	fp.getEmail().sendKeys("xxx");
	fp.sendMeInstructions().click();
	
	}
	@DataProvider
	public Object[][] getData()    //when we need to pass multiple data items to a testcase we use dataprovider annotation
	{
		Object[][] data =new Object[2][2];
		data[0][0]="nonrestricteduser@ab.com";
		data[0][1]="12345";
		data[1][0]="restricteduser@cd.com";
		data[1][1]="67890";
		return data;
		
	}
	 @AfterTest
	   public void teardown() {
		   driver.close();
	 }

}
