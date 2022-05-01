package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.DriverFactory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPageSteps {
	private static String title;
	public WebDriver driver=DriverFactory.getDriver();
	private LoginPage lp=new LoginPage(driver);
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  
	  driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
		 title= lp.getPageTitle();
		  System.out.println("My login page title is: "+title);
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String expTitle) {
		  Assert.assertEquals(title, expTitle);
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {
		lp.enterUsername(uname);
		lp.enterPwd(pwd);
	}

	@When("click on login button")
	public void click_on_login_button() {
	    lp.clickLogin();
	}
	
}
