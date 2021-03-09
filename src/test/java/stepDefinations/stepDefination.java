package stepDefinations;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.portalHomePage;
import resources.Central;

public class stepDefination  extends Central{
	

@Given("^Initialize the browser with firefox$")
public void initialize_the_browser_with_firefox() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver=initializeDriver();
    
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(arg1);
  
}

@Given("^Click on Login link in home page to land on source sign in page$")
public void click_on_Login_link_in_home_page_to_land_on_source_sign_in_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	LandingPage l=new LandingPage(driver); //creating the object of landing page to invoke those methods
	if(l.getPopupsize().size()>0)
	{
		l.getPopup().click();
	}
	l.getLogin().click();
}
@When("^user enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(username);
	lp.getPassword().sendKeys(password);
	lp.getLogin().click();
    
}





@Then("^Verify that user is sucessfully logged in$")
public void verify_that_user_is_sucessfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
   System.out.println("uccess");
   driver.close();
}


}
