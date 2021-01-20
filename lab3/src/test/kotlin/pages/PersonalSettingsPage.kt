package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class PersonalSettingsPage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun setContactField(name: String, soname: String): Pair<String, String> {
        val nameField = WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[1]")))

        nameField.clear()
        nameField.sendKeys(name)

        val sonameField = WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[2]")))
        sonameField.clear()
        sonameField.sendKeys(soname)

        WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Сохранить']")))
            .click()

        driver.navigate().refresh()

        return WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[1]"))).getAttribute("value") to
                WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[2]"))).getAttribute("value")
    }

}