package usecases

import data.TestCredentials
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage


class Authorization {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun authTest(driver: WebDriver) {
        val signInPage = MainPage(driver).getSignInPage()
        val authPage = signInPage.getAuthPage(TestCredentials.email, TestCredentials.password)
        val email = authPage.getAuthEmail()
        val title = authPage.getTitle()

        Assertions.assertEquals(TestCredentials.email, email)
        Assertions.assertEquals(title, "Главная страница")

        driver.quit()
    }
}