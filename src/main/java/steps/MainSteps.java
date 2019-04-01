package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MainSteps {

    private WebDriver driver = null;

    @Given("^value path to driver \"([^\"]*)\"$")
    public void valuePathToDriver(String arg0) throws Throwable {
        try {
            System.setProperty("webdriver.chrome.driver", arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^create driver$")
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @When("^get driver \"([^\"]*)\"$")
    public void getDriver(String arg0) throws Throwable {
        try {
            driver.get(arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^check driver is not null$")
    public void checkDriverIsNotNull() {
        if (driver == null)
            assertNull(driver);
    }

    @And("^check title is \"([^\"]*)\"$")
    public void checkTitleIs(String arg0) {
        assertEquals(arg0, driver.getTitle());
    }
}
