package lab3.model;

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

fun WebDriver.xpath(path: String) =
    WebDriverWait(this, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)))

