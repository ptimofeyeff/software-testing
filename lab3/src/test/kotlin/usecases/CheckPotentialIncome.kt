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


class CheckPotentialIncome {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it display potential income of user`(driver: WebDriver) {

        val mainPage = MainPage(driver)
        mainPage.calcIncome(Category.VEHICLE, Region.NorthAmerica)

        Assertions.assertEquals("Ваш потенциальный годовой доход*", mainPage.resultIncome.text)

        driver.quit()
    }
}
