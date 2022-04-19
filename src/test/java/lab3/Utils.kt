package lab3

import lombok.SneakyThrows
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

object Utils {
    const val CHROME_SYSTEM_PROPERTY_NAME = "webdriver.chrome.driver"
    const val CHROME_SYSTEM_PROPERTY_PATH = "drivers/chromedriver.exe"
    const val FIREFOX_SYSTEM_PROPERTY_NAME = "webdriver.gecko.driver"
    const val FIREFOX_SYSTEM_PROPERTY_PATH = "drivers/geckodriver.exe"
    const val BASE_URL = "https://www.answers.com/"
    const val USED_URL = "https://www.answers.com/search?q=&filter=all"
    const val CORRECT_LOGIN = "notgurev@gmail.com"
    const val CORRECT_PASSWORD = "!NdLnUEq6YCYSP."
    const val USERNAME = "notgurev"
    const val WRONG_PASSWORD = "Gavrilov"
    const val WRONG_LOGIN = "Yarkeev"

    @get:SneakyThrows
    val drivers: List<WebDriver>
        get() {
            prepareDrivers();
            val drivers: MutableList<WebDriver> = ArrayList()
            drivers.add(ChromeDriver());
            drivers.add(FirefoxDriver())
            return drivers
        }

    fun getElementBySelector(driver: WebDriver?, selector: By?): WebElement {
        val driverWait = WebDriverWait(driver, Duration.ofSeconds(10))
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector))
    }

    fun waitUntilPageLoads(driver: WebDriver?, timeout: Long) {
        val waitDriver = WebDriverWait(driver, timeout)
        waitDriver.until { webDriver: WebDriver -> (webDriver as JavascriptExecutor).executeScript("return document.readyState") == "complete" }
    }

    fun prepareDrivers() {
        System.setProperty(CHROME_SYSTEM_PROPERTY_NAME, CHROME_SYSTEM_PROPERTY_PATH)
        System.setProperty(FIREFOX_SYSTEM_PROPERTY_NAME, FIREFOX_SYSTEM_PROPERTY_PATH)
    }
}