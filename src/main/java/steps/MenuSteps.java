package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MenuSteps {

    private WebDriver driver;

    private String id;
    private String text;
    private String url;
    private WebElement menuItem;

    @Given("^menu item \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void menuItemAndAnd(String arg0, String arg1, String arg2) {
        driver = GlobalDriver.getDriver();
        id = arg0;
        text = arg1;
        url = arg2;
    }

    @When("^find element by id$")
    public void findElementById() {
        menuItem = driver.findElement(By.id(id));
    }

    @And("^click menu item$")
    public void clickMenuItem() {
        menuItem.click();
    }

    @Then("^check text$")
    public void checkText() {
        assertEquals(menuItem.getText(), text);
    }

    @And("^check url$")
    public void checkUrl() {
        assertEquals(driver.getCurrentUrl(), url);
    }
}
