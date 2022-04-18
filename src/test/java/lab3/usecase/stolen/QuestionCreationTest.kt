package lab3.usecase.stolen

import lab3.Utils
import lab3.cool.TestWithDrivers
import lab3.model.MainPage
import lab3.model.xpath
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.Dimension

class QuestionCreationTest : TestWithDrivers() {
    @Test
    fun tryCreateEmptyQuestion() {
        drivers.parallelStream().forEach { driver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mp = MainPage(driver)
            mp.login()
            with(driver) {
                xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[1]/div/button/button").click()
                xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[4]/div[1]/div/div/div/span[1]/button").click()
                xpath("/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[1]/button[2]").click()
                val alert = xpath("/html/body/div[1]/div[1]/div/div/div[5]/div/span[2]")
                Assertions.assertEquals(alert.text, "This field is required")
            }
        }
    }
}