package myHooks;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp(Scenario sc) {
        System.out.println("Starting scenario: " + sc.getName());
        DriverFactory.initDriver();
        System.out.println("Driver initialised");


    }

    @After
    public void tearDown(Scenario sc) {
        System.out.println("Scenario ended: " + sc.getName());

        DriverFactory.quitDriver();
        System.out.println("Driver closed");
    }
}
