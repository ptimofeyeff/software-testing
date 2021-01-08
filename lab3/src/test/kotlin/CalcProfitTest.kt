import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage
import java.util.concurrent.TimeUnit


class CalcProfitTest {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it display potential profit of user`(driver: WebDriver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        val mainPage = MainPage(driver)
        mainPage.calcProfit()

        Assertions.assertEquals("Ваш потенциальный годовой доход*", mainPage.resultProfit.text)

        Thread.sleep(1000)
        driver.quit()
    }
}
