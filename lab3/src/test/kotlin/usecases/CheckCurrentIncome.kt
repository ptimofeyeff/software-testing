package usecases

import data.TestCredentials
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class CheckCurrentIncome {

    private val expectedIncome = "0,00 \$"

    @RunWithChrome
    @RunWithFirefox
    @ParameterizedTest
    fun `it display current income`(driver: WebDriver) {
        val signInPage = MainPage(driver).getSignInPage()
        val authPage = signInPage.getAuthPage(TestCredentials.email, TestCredentials.password)

        val currentIncome = authPage.getCurrentIncome()

        Assertions.assertEquals(expectedIncome, currentIncome)

        driver.quit()
    }
}