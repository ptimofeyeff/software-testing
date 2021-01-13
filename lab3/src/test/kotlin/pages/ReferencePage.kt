package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class ReferencePage(
    private val driver: WebDriver
) {

    init {
        PageFactory.initElements(driver, this)
    }

    fun getReferenceArticle(section: String, theme: String): ReferenceArticlePage {
        WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//h2")))
        driver.findElement(By.xpath("//h2")).click()

        val sectionXPath = "//h2[text()='$section']"
        WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(sectionXPath)))

        driver.findElement(By.xpath(sectionXPath)).click()
        val themeXpath = "$sectionXPath/following-sibling::div/descendant::a[text()='$theme']"

        WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(themeXpath)))
        driver.findElement(By.xpath(themeXpath)).click()
        return ReferenceArticlePage(driver)
    }

}
