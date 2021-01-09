package pages

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class SolutionsPage(
    private val driver: WebDriver
) {

    @FindBy(xpath = "//h2[contains(text(), 'Экономьте время с автоматизированными объявлениями')]/following-sibling::a/span")
    lateinit var autoAdsDetailBtn: WebElement

    @FindBy(xpath = "//h2[contains(text(), 'Зарабатывайте больше с адаптивными рекламными объявлениями')]/following-sibling::a/span")
    lateinit var responsiveAdsDetailBtn: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

    fun getAdvantageHeader(solutionDetailBtn: WebElement, advantageNumber: Int): String {

        val jsDriver = driver as JavascriptExecutor
        jsDriver.executeScript("arguments[0].scrollIntoView(true)", solutionDetailBtn)
        Thread.sleep(500)

        solutionDetailBtn.click()
        return driver.findElement(By.xpath("(//div[@class='content'])[$advantageNumber]/h2"))
            .getAttribute("innerText").trim()
    }

}