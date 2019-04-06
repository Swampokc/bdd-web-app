package steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class BookingDateOutSteps {

    private WebDriver driver;

    @Given("^driver to dateOut$")
    public void driverToDateOut() {
        driver = GlobalDriver.getDriver();
    }

    @When("^insert text to dateOut input$")
    public void insertTextToDateOutInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dateOut').value='2019-04-10';");
    }

    @Then("^check the text of the DateOut input$")
    public void checkTheTextOfTheDateOutInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        assertEquals("2019-04-10", js.executeScript("return document.getElementById('dateOut').value;").toString());
    }
}
