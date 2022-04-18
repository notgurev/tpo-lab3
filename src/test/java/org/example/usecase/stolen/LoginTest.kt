package org.example.usecase.stolen

import org.example.Utils
import org.example.cool.TestWithDrivers
import org.example.model.MainPage
import org.junit.jupiter.api.Test
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver

class LoginTest : TestWithDrivers() {
    @Test
    fun login() {
        drivers.parallelStream().forEach { webDriver: WebDriver ->
            webDriver.get(Utils.BASE_URL)
            webDriver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(webDriver)
            mainPage.login()
        }
    }
}