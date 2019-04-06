package steps;

import cucumber.api.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BookingaPlacesSteps {

    WebDriver driver;

    @Given("^driver ta aPlaces$")
    public void driverTaAPlaces() {
        driver = GlobalDriver.getDriver();
    }

    @When("^insert text to aPlaces input$")
    public void insertTextToAPlacesInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('aPlaces').value='2';");
    }

    @Then("^check the text of the aPlaces input$")
    public void checkTheTextOfTheAPlacesInput() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        assertEquals("2", js.executeScript("return document.getElementById('aPlaces').value;").toString());
    }
}
