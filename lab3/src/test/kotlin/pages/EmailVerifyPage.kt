package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class EmailVerifyPage(
    private val driver: WebDriver
) {

    fun getConfirmationText(): String {
        WebDriverWait(driver, 10)
            .until(ExpectedConditions.urlContains("https://accounts.google.com/signup/v2/webverifyemail"))

        return driver.findElement(By.xpath("//div[@class='PrDSKc']")).getAttribute("innerText")
    }


}