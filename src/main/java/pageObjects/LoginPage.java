package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

public WebDriver driver;
    By email= By.cssSelector("input[id='user_email']");  
    By password= By.cssSelector("[type='password']"); 
    By login= By.cssSelector("[value='Log In']"); 
    By forgotpassword=By.cssSelector("[href*='password/new']");
    public LoginPage(WebDriver driver) {      //constructor to send the life of the driver to the other class as argument
		// TODO Auto-generated constructor stub
    	this.driver=driver;
	}
	public WebElement getEmail() {
    	return driver.findElement(email);
    }
	public WebElement getPassword() {
    	return driver.findElement(password);
    }
	public WebElement getLogin() {
    	return driver.findElement(login);
    	
	}
    	public ForgotPassword forgotPassword() {
        driver.findElement(forgotpassword).click();
        ForgotPassword fp=new ForgotPassword(driver);
        return fp;

    }


}



