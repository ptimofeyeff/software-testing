package pages

import data.Category
import data.Region
import helpers.waitForClick
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory


class MainPage(
    private val driver: WebDriver
) {

    @FindBy(xpath = "//div[@class='revenue-results-container']//h3")
    lateinit var resultProfit: WebElement

    @FindBy(xpath = "//div[@class='ytp-time-display notranslate' and string-length(@style)=0]//span[@class='ytp-time-current']")
    lateinit var currentPlayingTime: WebElement

    @FindBy(xpath = "//span[@class='cookieBarButtons']//a[text()='ОК']")
    lateinit var cookieOkBtn: WebElement

    @FindBy(xpath = "(//a[text()='Войти'])[1]")
    lateinit var signInBtn: WebElement

    init {
        driver.get("https://www.google.com/adsense/")
        PageFactory.initElements(driver, this)
    }

    fun calcProfit(category: Category, region: Region) {
        cookieOkBtn.click()
        driver.findElement(By.xpath("//button[@aria-label='Выберите регион']")).click()
        driver.findElement(By.xpath("//button[text()='${region.value}']")).click()
        driver.findElement(By.xpath("//button[@aria-label='Выберите категорию']")).click()
        driver.findElement(By.xpath("//button[text()='${category.value}']")).click()

        waitForClick(driver.findElement(By.xpath("//button[text()='Рассчитать']")))

    }

    fun startWork(): RegisterPage {
        driver.findElement(By.xpath("(//a[@href='https://www.google.com/adsense/signup'])[1]")).click()
        return RegisterPage(driver)
    }

    fun getSolutionsPage(): SolutionsPage {
        cookieOkBtn.click()
        driver.findElement(By.xpath("(//a[text()='Решения'])[1]")).click()
        return SolutionsPage(driver)
    }

    fun getResourcePage(): ResourcePage {
        cookieOkBtn.click()
        driver.findElement(By.xpath("(//a[text()='Ресурсы'])[1]")).click()
        return ResourcePage(driver)
    }

    fun getReferencePage(): ReferencePage {
        cookieOkBtn.click()

        Actions(driver).sendKeys(Keys.END).perform()
        waitForClick(driver.findElement(By.xpath("//a[text()='Справочный центр AdSense']")))

        driver.windowHandles.forEach {
            if (it != driver.windowHandle) driver.switchTo().window(it)
        }

        return ReferencePage(driver)
    }

    fun getSignInPage(): SignInPage {
        signInBtn.click()
        return SignInPage(driver)
    }

    fun watchSuccessStories() {
        val successStories = driver.findElement(By.xpath("//a[@class='h-c-header__nav-li-link' and text()='Истории успеха']"))
        val watchVideo = driver.findElement(By.xpath("//a[@class='h-c-link h-c-link--video ng-isolate-scope']"))
        successStories.click()
        watchVideo.click()
    }

}








