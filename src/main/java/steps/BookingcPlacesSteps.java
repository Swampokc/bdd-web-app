package steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BookingcPlacesSteps {

    WebDriver driver;

    @Given("^driver to cPlaces$")
    public void driverToCPlaces() {
        driver = GlobalDriver.getDriver();
    }

    @When("^insert text to cPlaces input$")
    public void insertTextToCPlacesInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('cPlaces').value='2';");
    }

    @Then("^check the text of the cPlaces input$")
    public void checkTheTextOfTheCPlacesInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        assertEquals("2", js.executeScript("return document.getElementById('cPlaces').value;").toString());
    }
}
