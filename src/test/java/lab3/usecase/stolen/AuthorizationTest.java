package lab3.usecase.stolen;

import lab3.Utils;
import lab3.cool.TestWithDrivers;
import lab3.model.stolen.AdultConfirmationPage;
import lab3.model.stolen.MainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthorizationTest extends TestWithDrivers {
    @Test
    void loginTest() {
        drivers.parallelStream().forEach(webDriver -> {
            AdultConfirmationPage adultConfirmationPage = new AdultConfirmationPage(webDriver);
            MainPage mainPage = new MainPage(webDriver);
            webDriver.get(Utils.BASE_URL);
            adultConfirmationPage.acceptAdultConfirmation();
            mainPage.doLogin();
            WebElement login = Utils.getElementBySelector(webDriver, By.xpath(".//div[@id='header_login']/div/div[3]/a[2]"));
            assertEquals(Utils.CORRECT_LOGIN, login.getText());
        });
    }

    @Test
    void logoutTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            AdultConfirmationPage adultConfirmationPage = new AdultConfirmationPage(webDriver);
            MainPage mainPage = new MainPage(webDriver);
            webDriver.get(Utils.BASE_URL);
            adultConfirmationPage.acceptAdultConfirmation();
            mainPage.doLogin();
            Utils.waitUntilPageLoads(webDriver, 10);
            mainPage.doLogout();
            Utils.waitUntilPageLoads(webDriver, 10);
            assertEquals("ЛОГИН", Utils.getElementBySelector(webDriver, By.xpath("//*[@id=\"header_login\"]/a[1]")).getText());
            webDriver.quit();
        });
    }

    @Test
    void wrongLoginTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            AdultConfirmationPage adultConfirmationPage = new AdultConfirmationPage(webDriver);
            MainPage mainPage = new MainPage(webDriver);
            webDriver.get(Utils.BASE_URL);
            adultConfirmationPage.acceptAdultConfirmation();
            mainPage.doWrongLogin();
            assertThrows(TimeoutException.class, () -> Utils.getElementBySelector(webDriver, By.xpath(".//div[@id='header_login']/div/div[3]/a[2]")));
        });
        drivers.forEach(WebDriver::quit);
    }
}

