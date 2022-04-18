package org.example.model

import org.example.Utils.CORRECT_LOGIN
import org.example.Utils.CORRECT_PASSWORD
import org.openqa.selenium.WebDriver

class MainPage(driver: WebDriver?) : Page(driver) {
    fun login() = with(driver) {
        xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[3]/span/button").click()
        xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[2]/div[2]/div/button[4]").click()
        xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[1]/div/input").sendKeys(
            CORRECT_LOGIN
        )
        xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/div[2]/div/input").sendKeys(
            CORRECT_PASSWORD
        )
        xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/button").click()
    }
}