package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class LoginSteps {

    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    private WebDriver driver = DriverFactory.getDriver();
    // ✅ Retrieve the thread-local driver

    //System.out.println("Check if println works now");

    LoginPage login=new LoginPage(driver);

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        logger.info("This is an info log message.");

        driver.get("https://automationexercise.com/login");

        System.out.println("User is on Login Page");

    }

    @When("User enters correct username {string} and correct password {string}")
    public void user_enters_correct_username_and_correct_password(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);

        System.out.println("User enter Correct username and password");

    }

    @When("click on Login button")
    public void click_on_login_button() {
        login.clickOnLogin();
        System.out.println("User clicks on login button");
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actual=login.getPageTitle();
        String expected="Automation Exercise";
        Assert.assertEquals("Page Title verified",expected, actual);

        System.out.println("User is able to login successfully");


    }
}
