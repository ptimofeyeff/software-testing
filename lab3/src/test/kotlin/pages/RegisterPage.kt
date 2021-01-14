package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class RegisterPage(
    private val driver: WebDriver
) {

    fun registration(targetSiteUrl: String, email: String): GoogleCreateAccountPage {
        WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[1]")))
            .sendKeys(targetSiteUrl)

        driver.findElement(By.xpath("(//input)[2]"))
            .sendKeys(email)

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("(//material-icon)[3]")))
            .click()

        driver.findElement(By.xpath("//material-button[@debugid='submit-button']"))
            .click()

        return GoogleCreateAccountPage(driver)
    }
}