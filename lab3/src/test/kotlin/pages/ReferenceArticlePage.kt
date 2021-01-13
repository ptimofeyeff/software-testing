package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class ReferenceArticlePage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun getArticleText() = driver.findElement(By.xpath("//h1")).getAttribute("innerText").trim()

}