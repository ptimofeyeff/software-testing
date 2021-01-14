package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class GoogleCreateAccountPage(
    private val driver: WebDriver
) {
    fun createAccount(
        testName: String,
        testSoname: String,
        testPassword: String,
        testEmail: String
    ): EmailVerifyPage {
        WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")))

        driver.findElement(By.id("firstName")).sendKeys(testName)
        driver.findElement(By.id("lastName")).sendKeys(testSoname)
        driver.findElement(By.id("username")).apply { clear(); sendKeys(testEmail) }
        driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(testPassword)
        driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys(testPassword)
        driver.findElement(By.xpath("(//button)[2]")).click()

        return EmailVerifyPage(driver)
    }
}