package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class GoogleCreateAccountPage(
    private val driver: WebDriver,
    private val TEST_EMAIL: String
) {

    fun createAccount(): String {
        val firstNameInput = driver.findElement(By.id("firstName"))
        val lastNameInput = driver.findElement(By.id("lastName"))
        val emailInput = driver.findElement(By.id("username"))
        val passwordInput = driver.findElement(By.xpath("//input[@name='Passwd']"))
        val confirmPasswordInput = driver.findElement(By.xpath("//input[@name='ConfirmPasswd']"))
        val nextButton = driver.findElement(By.xpath("(//button)[2]"))

        firstNameInput.sendKeys("Pavel")
        lastNameInput.sendKeys("Timofeev")
        emailInput.clear()
        emailInput.sendKeys(TEST_EMAIL)
        passwordInput.sendKeys("testPassword")
        confirmPasswordInput.sendKeys("testPassword")
        nextButton.click()

        return driver.findElement(By.xpath("//div[@class='PrDSKc']")).getAttribute("innerHTML")
    }
}