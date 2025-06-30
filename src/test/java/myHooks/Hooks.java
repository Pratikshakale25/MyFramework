package myHooks;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @Before ("not @API")
    public void setUp(Scenario sc) {
        System.out.println("Starting scenario: " + sc.getName());
        DriverFactory.initDriver();
        System.out.println("Driver initialised");


    }

    @After (value = "not @API", order = 1)
    public void tearDown(Scenario sc) {
        System.out.println("Scenario ended: " + sc.getName());

        DriverFactory.quitDriver();
        System.out.println("Driver closed");
    }

    @After(value = "not @API", order = 2)
    public void tearDown2(Scenario sc) {

        byte[] screenshot = ScreenshotUtil.captureScreenshotAsBytes(DriverFactory.getDriver());
        sc.attach(screenshot, "image/png", "screenshot");


        System.out.println("Test Failed Screenshot attached");
    }
}
