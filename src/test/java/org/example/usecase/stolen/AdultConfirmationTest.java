package org.example.usecase.stolen;

import org.example.Utils;
import org.example.cool.TestWithDrivers;
import org.example.model.stolen.AdultConfirmationPage;
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

