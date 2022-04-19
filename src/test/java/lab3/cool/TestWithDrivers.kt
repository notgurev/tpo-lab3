package lab3.cool

import lab3.Utils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import java.util.function.Consumer

abstract class TestWithDrivers {
    var drivers: List<WebDriver>? = null
    @BeforeEach
    private fun beforeEach() { // todo before all?
        drivers = Utils.drivers
    }

    @AfterEach
    private fun afterEach() {
        drivers!!.forEach(Consumer { obj: WebDriver -> obj.quit() })
    }

    companion object {
        @BeforeAll
        fun prepareDrivers() {
            Utils.prepareDrivers()
        }
    }
}