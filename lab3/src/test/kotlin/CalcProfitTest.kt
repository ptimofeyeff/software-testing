import helpers.RunWithChrome
import helpers.RunWithFirefox
import helpers.WebDriverTemplateInvocationContextProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.WebDriver
import pages.MainPage

@ExtendWith(WebDriverTemplateInvocationContextProvider::class)
class CalcProfitTest {


    @TestTemplate
    @RunWithFirefox
    @RunWithChrome
    fun `it display potential profit of user`(driver: WebDriver) {
        val mainPage = MainPage(driver)

        mainPage.calcProfit()
        Assertions.assertEquals("Ваш потенциальный годовой доход*", mainPage.resultProfit.text)
        Thread.sleep(1000)
        driver.quit()
    }
}
