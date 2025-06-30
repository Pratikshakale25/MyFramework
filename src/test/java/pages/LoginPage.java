package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class LoginPage
{
    WebDriver driver;
    WaitUtil wait;

    public LoginPage(WebDriver driver)
    {

        this.driver=driver;
        this.wait= new WaitUtil(driver,5);
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement username;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedIn;

    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    private WebElement errorelement;


    public void enterUsername(String userName)
    {
        //driver.findElement(username).sendKeys(userName);
        wait.waitForVisibility(username).sendKeys(userName);
    }

    public void enterPassword(String PassWord)
    {
        //driver.findElement(password).sendKeys(PassWord);
        wait.waitForVisibility(password).sendKeys(PassWord);
    }

    public void clickOnLogin(){
        //driver.findElement(loginButton).click();
        wait.waitForElementToBeClickable(loginButton).click();

    }


    public boolean loggedIn(){
        System.out.println(wait.waitForVisibility(loggedIn));
        return ((loggedIn).isDisplayed());
    }


    public String getErrorMsg()
    {
        return (wait.waitForVisibility(errorelement)).getText();
    }



}
