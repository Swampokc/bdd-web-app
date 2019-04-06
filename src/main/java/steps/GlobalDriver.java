package steps;

import org.openqa.selenium.WebDriver;

public class GlobalDriver {

    public static WebDriver driver;

    public static void setDriver(WebDriver getting_driver) {
        driver = getting_driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
