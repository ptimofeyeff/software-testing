package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class RegisterPage(
    private val driver: WebDriver
) {

    fun registration() {
        WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[1]")))
            .sendKeys("testLab.com")

        driver.findElement(By.xpath("(//input)[2]"))
            .sendKeys("jirediv919@aranelab.com")

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("(//material-icon)[3]")))
            .click()

        driver.findElement(By.xpath("//material-button[@debugid='submit-button']"))
            .click()
    }
}