package lab3.usecase.stolen

import lab3.Utils
import lab3.cool.TestWithDrivers
import lab3.model.MainPage
import lab3.model.xpath
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.Dimension
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver

class QuestionSearch: TestWithDrivers() {

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

    @Test
    fun searchQuestion() {
        drivers.parallelStream().forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            with (mainPage) {
                searchWithParameters()
                setParameter(1)
                setSearch()
            }
            val element = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[2]/div[1]")
            Assertions.assertEquals(element.text, "Search results")
            val activeTab = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/a[2]")
            Assertions.assertEquals(activeTab.getAttribute("class").contains("border-primaryColor"), true)
        }
    }

    @Test
    fun searchGuide() {
        drivers.parallelStream().forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            with (mainPage) {
                searchWithParameters()
                setParameter(2)
                setSearch()
            }
            val element = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[3]/div[1]")
            Assertions.assertEquals(element.text, "Study Guides")
            val activeTab = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/a[3]")
            Assertions.assertEquals(activeTab.getAttribute("class").contains("border-primaryColor"), true)
        }
    }

    @Test
    fun searchEmpty() {
        drivers.parallelStream().forEach { driver: WebDriver ->
            driver.get(Utils.BASE_URL)
            driver.manage().window().size = Dimension(1100, 674)
            val mainPage = MainPage(driver)
            mainPage.search()
            driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[3]/form/div/div/div/div[1]/img[2]").click()
            val searchField = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[3]/form/div/div/div/div[1]/input")
            searchField.sendKeys(Keys.ENTER)
            val element = driver.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/h2")
            Assertions.assertEquals(element.text, "Hmm... looks like we couldn’t find an answer.")
        }
    }
}