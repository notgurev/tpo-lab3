package lab3.usecase

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
        drivers?.parallelStream()?.forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.login()
            mainPage.goToProfile()
            val username =
                driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/h1")
            Assertions.assertEquals(username.text, Utils.USERNAME)
        }
    }

    @Test
    fun loginWrongPassword() {
        drivers?.parallelStream()?.forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.loginWrongPassword()
            val message = driver.xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[2]/span")
            Assertions.assertEquals(message.text, "Incorrect username or password")
        }
    }

    @Test
    fun loginWrongEmail() {
        drivers?.parallelStream()?.forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.loginWrongEmail()
            val message = driver.xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[2]/span")
            Assertions.assertEquals(message.text, "Incorrect username or password")
        }
    }

    @Test
    fun logout() {
        drivers?.parallelStream()?.forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.login()
            mainPage.logout()
            val loginButton = driver.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/button")
            Assertions.assertEquals(loginButton.text, "Log in")
        }
    }
}