package lab3.model

import lab3.Utils.CORRECT_LOGIN
import lab3.Utils.CORRECT_PASSWORD
import org.openqa.selenium.WebDriver

class MainPage(driver: WebDriver?) : Page(driver) {
    fun login() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/button").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[2]/div[2]/div/button[4]").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[1]/div/input").sendKeys(
                CORRECT_LOGIN
            )
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[2]/div/input").sendKeys(
                CORRECT_PASSWORD
            )
            xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/button").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/button/a/img").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/div/div/a[1]/button/a").click()
        }
    }

    fun search() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/div/div[1]/input").sendKeys("java")
            xpath("/html/body/div[1]/div[1]/div/div/div[2]/main/section[1]/div[2]/button").click()
        }
    }

    fun logout() {
        with(driver) {
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/button/a/img").click()
            xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/div/div/div/a[3]/button/a").click()
        }
    }
}