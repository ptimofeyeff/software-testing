package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class ResourcePage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun getArticlePage(articleName: String): ArticlePage {
        val readArticleBtn = driver.findElement(By.xpath("//h4[contains(text(), '$articleName')]"))
        readArticleBtn.click()

        return ArticlePage(driver)
    }

}