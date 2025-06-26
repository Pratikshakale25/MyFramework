package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By username= By.xpath("//input[@data-qa='login-email']");
    private By password= By.xpath("//input[@data-qa='login-password']");
    private By loginButton= By.xpath("//button[text()='Login']");
    private By loggedIn=By.xpath("//*[contains(text(),'Logged in as')]");


    public void enterUsername(String userName)
    {
        driver.findElement(username).sendKeys(userName);
    }

    public void enterPassword(String PassWord)
    {
        driver.findElement(password).sendKeys(PassWord);
    }

    public void clickOnLogin(){
        driver.findElement(loginButton).click();

    }


    public String getPageTitle(){
        System.out.println(driver.findElement(loggedIn).getText());
        return driver.getTitle();
    }



}
