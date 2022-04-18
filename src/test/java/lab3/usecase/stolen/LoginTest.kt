package lab3.usecase.stolen

import lab3.Utils
import lab3.cool.TestWithDrivers
import lab3.model.MainPage
import lab3.model.xpath
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver

class LoginTest : TestWithDrivers() {
    @Test
    fun login() {
        drivers.parallelStream().forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.login()
            val username =
                driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/h1")
            Assertions.assertEquals(username.text, Utils.USERNAME)
        }
    }

    @Test
    fun logout() {
        drivers.parallelStream().forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.login()
            driver.get(Utils.BASE_URL)
            mainPage.logout()
            val loginButton = driver.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/button")
            Assertions.assertEquals(loginButton.text, "Log in")
        }
    }

    @Test
    fun search() {
        drivers.parallelStream().forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.search()
            val element = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[2]/div[12]/div[1]")
            Assertions.assertEquals(element.text, "Search results")
        }
    }
}