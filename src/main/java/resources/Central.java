package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Central {
	public WebDriver driver;
public	Properties prop;// creating driver object to access it in every browser
	public WebDriver initializeDriver() throws IOException  //initializing the browser in base class we can access the browser from here to the testcases
	{
		prop=new Properties();  // invoking properties class
		FileInputStream fis=new FileInputStream("C:\\nikhil\\nikhil\\src\\main\\java\\resources\\data.properties");//reading properties file
		prop.load(fis);//loading
	    String browserName=prop.getProperty("browser");//loading the browser name in string
	    System.out.println(browserName);
	    if(browserName.contains("firefox")) // selecting a browserr from browsers; .equals method is used whenever we returns any object 
	    {
	    	System.setProperty("webdriver.gecko.driver", "C:\\nikhil\\geckodriver.exe");
			driver=new FirefoxDriver();
	    }
	    else if(browserName.equals("chrome"))
	    {
	    	//code for chrome
	    }
	    else if(browserName.equals("ie"))
	    {
	    	//code for ie
	    }
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit time out for the project
	    return driver;  // returning the driver object to access it in the testcases
		
	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
