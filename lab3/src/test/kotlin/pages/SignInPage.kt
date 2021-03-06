package pages

import helpers.waitForClickToAnotherPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SignInPage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun getCreateAccountPage(): GoogleCreateAccountPage {

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Создать аккаунт']")))
            .click()

        waitForClickToAnotherPage(driver, "//div[text()='Для себя']")

        return GoogleCreateAccountPage(driver)
    }

    fun getAuthPage(email: String, password: String): AuthorizedUserPage {
        WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")))
            .sendKeys(email)

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@jsname='LgbsSe']")))
            .click()

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")))
            .sendKeys(password)

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@jsname='LgbsSe']")))
            .click()

        return AuthorizedUserPage(driver)
    }
}