package lab3.usecase.stolen;

import lab3.Utils;
import lab3.cool.TestWithDrivers;
import lab3.model.stolen.AdultConfirmationPage;
import org.junit.jupiter.api.*;

public class AdultConfirmationTest extends TestWithDrivers {
    @Test
    void acceptAdultConfirmationTest() {
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            AdultConfirmationPage page = new AdultConfirmationPage(webDriver);
            page.acceptAdultConfirmation();
        });
    }

    @Test
    void dismissAdultConfirmationTest() {
        drivers.parallelStream().forEach(webDriver -> {
            webDriver.get(Utils.BASE_URL);
            AdultConfirmationPage page = new AdultConfirmationPage(webDriver);
            page.dismissAdultConfirmation();
        });
    }
}

