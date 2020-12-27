package pages

import helpers.findElementByXpath
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class MainPage(
    private val driver: WebDriver
) {

    @FindBy(xpath = "//div[@class='revenue-results-container']//h3")
    lateinit var resultProfit: WebElement
    @FindBy(xpath = "//div[@class='ytp-time-display notranslate' and string-length(@style)=0]//span[@class='ytp-time-current']")
    lateinit var currentPlayingTime: WebElement

    init {
        driver.get("https://www.google.com/adsense/")
        PageFactory.initElements(driver, this)
    }

    fun calcProfit() {
        val cookiesOk = driver.findElementByXpath("//span[@class='cookieBarButtons']//a[text()='ОК']")
        cookiesOk.click()

        val regionSelector = driver.findElementByXpath("//button[@aria-label='Выберите регион']")
        val NARegion = driver.findElementByXpath("//button[text()='Северная Америка']")
        val categorySelector = driver.findElementByXpath("//button[@aria-label='Выберите категорию']")
        val peopleAndSociety = driver.findElementByXpath("//button[text()='Люди и общество']")
        val calcButton = driver.findElementByXpath("//button[text()='Рассчитать']")

        regionSelector.click()
        NARegion.click()
        categorySelector.click()
        peopleAndSociety.click()
        calcButton.click()
    }

    fun startWork() {
        val signUpButton = driver.findElementByXpath("(//a[@href='https://www.google.com/adsense/signup'])[1]")
        signUpButton.click()
    }

    fun watchSuccessStories(){
        val successStories = driver.findElementByXpath("//a[@class='h-c-header__nav-li-link' and text()='Истории успеха']")
        val watchVideo = driver.findElementByXpath("//a[@class='h-c-link h-c-link--video ng-isolate-scope']")
        successStories.click()
        watchVideo.click()
    }


}








