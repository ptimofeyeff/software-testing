package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class GoogleCreateAccountPage(
    private val driver: WebDriver,
    private val testName: String,
    private val testSoname: String,
    private val testPassword: String,
    private val testEmail: String
) {
    fun createAccount() {
        WebDriverWait(driver, 10)
            .until(ExpectedConditions.urlContains("https://accounts.google.com/signup/v2/webcreateaccount"))

        driver.findElement(By.id("firstName")).sendKeys(testName)
        driver.findElement(By.id("lastName")).sendKeys(testSoname)
        driver.findElement(By.id("username")).apply { clear(); sendKeys(testEmail) }
        driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(testPassword)
        driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys(testPassword)
        driver.findElement(By.xpath("(//button)[2]")).click()
    }
}