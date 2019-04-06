package steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class BookingDateInSteps {

    private WebDriver driver;

    @Given("^driver to date In$")
    public void driverToDateIn() {
        driver = GlobalDriver.getDriver();
    }

    @When("^insert text to dateIn input$")
    public void insertTextToDateInInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dateIn').value='2019-04-06';");
    }

    @Then("^check the text of the DateIn input$")
    public void checkTheTextOfTheDateInInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        assertEquals("2019-04-06", js.executeScript("return document.getElementById('dateIn').value;").toString());
    }
}
