package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage


class Authorization {

    private val testEmail = "jaheg53734@majorsww.com"
    private val testPasswd = "testPasswd"

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun authTest(driver: WebDriver) {
        val signInPage = MainPage(driver).getSignInPage()
        val authPage = signInPage.getAuthPage(testEmail, testPasswd)
        val email = authPage.getAuthEmail()
        val title = authPage.getTitle()

        Assertions.assertEquals(testEmail, email)
        Assertions.assertEquals(title, "Главная страница")

        driver.quit()
    }
}