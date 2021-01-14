package pages

import helpers.waitForClickWithRefreshElement
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class AuthorizedUserPage(
    private val driver: WebDriver
) {

    fun getAuthEmail(): String {

        waitForClickWithRefreshElement(driver, "//img[contains(@alt, 'Аккаунт Google')]")

        return WebDriverWait(driver, 15)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'email')]")))
            .getAttribute("innerText")
    }

    fun getTitle(): String {
        return WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")))
            .getAttribute("innerText")
    }
}