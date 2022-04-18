package lab3.model

import lab3.Utils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class MainPage(driver: WebDriver?) : Page(driver) {
    private fun tryLogin(username: String, password: String) {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/button").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[2]/div[2]/div/button[4]").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[1]/div/input").sendKeys(
                username
            )
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[2]/div/input").sendKeys(
                password
            )
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/button").click()
        }
    }

    fun goToProfile() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/button/a/img").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/div/div/a[1]/button/a").click()
        }
    }

    fun login() {
        tryLogin(Utils.CORRECT_LOGIN, Utils.CORRECT_PASSWORD)
    }

    fun search() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/div/div[1]/input").sendKeys("java")
            xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/button").click()
        }
    }

    fun searchWithParameters() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/div/div[1]/input").sendKeys("java")
            xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/button").click()
            findElement(By.cssSelector(".text-grey")).click() // xpath не работает
        }
    }

    fun setParameter(number: Number) {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[4]/div/div[2]/div[2]/button/div").click()
            xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[4]/div/div[2]/div[2]/div/div/span[${number}]").click()
        }
    }

    fun setMin(number: Number) {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[4]/div/div[2]/input[2]").sendKeys(number.toString())
        }
    }

    fun setSearch() {
        driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[4]/div/div[2]/div[7]/button").click()
    }

    fun logout() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/button/a/img").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/div/div/a[3]/button/a").click()
        }
    }

    fun loginWrongPassword() {
        tryLogin(Utils.CORRECT_LOGIN, Utils.WRONG_PASSWORD)
    }

    fun loginWrongEmail() {
        tryLogin(Utils.WRONG_LOGIN, Utils.CORRECT_PASSWORD)
    }
}