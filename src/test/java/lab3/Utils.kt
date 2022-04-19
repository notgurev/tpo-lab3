package lab3;


import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String CHROME_SYSTEM_PROPERTY_PATH = "drivers/chromedriver.exe";
    public static final String FIREFOX_SYSTEM_PROPERTY_NAME = "webdriver.gecko.driver";
    public static final String FIREFOX_SYSTEM_PROPERTY_PATH = "drivers/geckodriver.exe";
    public static final String BASE_URL = "https://www.answers.com/";
    public static final String USED_URL = "https://www.answers.com/search?q=&filter=all";

    public static final String CORRECT_LOGIN = "notgurev@gmail.com";
    public static final String CORRECT_PASSWORD = "!NdLnUEq6YCYSP.";
    public static final String USERNAME = "notgurev";
    public static final String WRONG_PASSWORD = "Gavrilov";
    public static final String WRONG_LOGIN = "Yarkeev";

    @SneakyThrows
    public static List<WebDriver> getDrivers() {
//        Utils.prepareDrivers();
        List<WebDriver> drivers = new ArrayList<>();
        //drivers.add(new ChromeDriver());
        drivers.add(new FirefoxDriver());
        return drivers;
    }

    public static WebElement getElementBySelector(WebDriver driver, By selector) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static void waitUntilPageLoads(WebDriver driver, long timeout) {
        WebDriverWait waitDriver = new WebDriverWait(driver, timeout);
        waitDriver.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH);
        System.setProperty(FIREFOX_SYSTEM_PROPERTY_NAME, FIREFOX_SYSTEM_PROPERTY_PATH);
    }
}
