package usecases

import data.Category
import data.Region
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage
import java.util.concurrent.TimeUnit


class CheckPotentialProfit {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it display potential profit of user`(driver: WebDriver) {

        val mainPage = MainPage(driver)
        mainPage.calcProfit(Category.VEHICLE, Region.NorthAmerica)

        Assertions.assertEquals("Ваш потенциальный годовой доход*", mainPage.resultProfit.text)

        Thread.sleep(1000)
        driver.quit()
    }
}
