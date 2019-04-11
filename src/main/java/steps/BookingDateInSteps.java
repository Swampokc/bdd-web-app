package steps;

import cucumber.api.java.en.*;
import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BookingDateInSteps {

    private WebDriver driver;

    @Given("^driver to date In$")
    public void driverToDateIn() {
        driver = GlobalDriver.getDriver();
    }

    @When("^insert text to dateIn input$")
    public void insertTextToDateInInput() {
        WebElement we = driver.findElement(By.id("dateIn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dateIn').value='2019-04-06';");
    }

    @Then("^check the text of the DateIn input$")
    public void checkTheTextOfTheDateInInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        assertEquals("2019-04-06", js.executeScript("return document.getElementById('dateIn').value;").toString());
    }
}
