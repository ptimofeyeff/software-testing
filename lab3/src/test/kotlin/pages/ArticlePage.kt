package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class ArticlePage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun getArticleText(): String {
        return driver.findElement(By.xpath("//p[@class='intro']")).getAttribute("innerText").trim()
    }
}