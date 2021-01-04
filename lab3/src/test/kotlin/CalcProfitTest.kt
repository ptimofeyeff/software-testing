import helpers.WebDriverArgumentsProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import org.openqa.selenium.WebDriver
import pages.MainPage
import java.util.concurrent.TimeUnit


class CalcProfitTest {

    @ParameterizedTest
    @ArgumentsSource(WebDriverArgumentsProvider::class)
    fun `it display potential profit of user`(driver: WebDriver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)

        val mainPage = MainPage(driver)
        mainPage.calcProfit()

        Assertions.assertEquals("Ваш потенциальный годовой доход*", mainPage.resultProfit.text)

        Thread.sleep(1000)
        driver.quit()
    }
}
