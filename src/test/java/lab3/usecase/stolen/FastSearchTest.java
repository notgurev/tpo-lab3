package lab3.usecase.stolen;

import lab3.Utils;
import lab3.model.stolen.AdultConfirmationPage;
import lab3.model.stolen.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FastSearchTest {

    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @Test
    void fastSearchTest() {
        List<WebDriver> drivers = Utils.getDrivers();
        drivers.parallelStream().forEach(webDriver -> {
            AdultConfirmationPage adultConfirmationPage = new AdultConfirmationPage(webDriver);
            MainPage mainPage = new MainPage(webDriver);
            webDriver.get(Utils.BASE_URL);
            adultConfirmationPage.acceptAdultConfirmation();
            mainPage.doFastSearch();
            WebElement womanFilter = Utils.getElementBySelector(webDriver, By.xpath("/html/body/div[1]/div[7]/div[1]/div/div/div[1]/div[4]/div/div/div[2]/div[1]/div[1]"));
            WebElement russianFilter = Utils.getElementBySelector(webDriver, By.xpath("/html/body/div[1]/div[7]/div[1]/div/div/div[1]/div[4]/div/div/div[2]/div[1]/div[2]"));
            assertEquals("Женщины\n×", womanFilter.getText());
            assertEquals("Россия / Украина\n×", russianFilter.getText());
        });
        drivers.forEach(WebDriver::quit);
    }
}

