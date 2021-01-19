package pages

import helpers.waitForClickWithAction
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

    fun sendFeedback(feedback: String): String {

        waitForClickWithAction(driver, "//div[text()='Отзыв']") {
            driver.findElement(By.xpath("//button[@aria-label='Главное меню']"))
                .click()
            WebDriverWait(driver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Отзыв']")))
        }

        val iframe = WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='google-feedback-wizard']")))

        driver.switchTo().frame(iframe)

        driver.findElement(By.xpath("//textarea[@placeholder]"))
            .sendKeys(feedback)

        driver.findElement(By.xpath("//input[@type='checkbox']"))
            .click()

        driver.findElement(By.xpath("//button[@key='send']"))
            .click()

        return WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@key='thanks']")))
            .getAttribute("innerText")
    }
}