package helpers

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.lang.Exception

fun waitForClick(element: WebElement) {
    while (true) {
        try {
            element.click()
            break
        } catch (e: Exception) { }
    }
}

fun waitForClickWithRefreshElement(driver: WebDriver, xpath: String) {
    while (true) {
        try {
            driver.findElement(By.xpath(xpath))
                .click()
            break
        } catch (e: Exception) { }
    }
}

fun waitForClickToAnotherPage(driver: WebDriver, xpath: String) {
    try {
        while (true)
            driver.findElement(By.xpath(xpath)).click()
    } catch (e: Exception) { }
}