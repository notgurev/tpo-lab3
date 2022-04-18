package org.example.cool;

import org.example.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class TestWithDrivers {
    public List<WebDriver> drivers;

    @BeforeAll
    public static void prepareDrivers() {
        Utils.prepareDrivers();
    }

    @BeforeEach
    private void beforeEach() { // todo before all?
        drivers = Utils.getDrivers();
    }

    @AfterEach
    private void afterEach() {
        drivers.forEach(WebDriver::quit);
    }
}
