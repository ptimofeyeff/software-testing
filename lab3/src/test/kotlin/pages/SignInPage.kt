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

}