package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class RegisterPage(
    private val driver: WebDriver
) {

    fun registration() {
        val urlField = driver.findElement(By.xpath("(//input)[1]"))
        val emailField = driver.findElement(By.xpath("(//input)[2]"))
        val spamRadio = driver.findElement(By.xpath("(//material-icon)[3]"))
        val saveAndResumeButton = driver.findElement(By.xpath("//material-button[@debugid='submit-button']"))

        urlField.sendKeys("testLab.com")
        emailField.sendKeys("jirediv919@aranelab.com")
        spamRadio.click()
        saveAndResumeButton.click()

    }
}