package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class GiveFeedback {

    private val testEmail = "jaheg53734@majorsww.com"
    private val testPasswd = "testPasswd"
    private val testFeedback = "testFeedback"


    @RunWithChrome
    @RunWithFirefox
    @ParameterizedTest
    fun `it display thanks text for submitting feedback`(driver: WebDriver) {
        val signInPage = MainPage(driver).getSignInPage()
        val authPage = signInPage.getAuthPage(testEmail, testPasswd)

        val confirmText = authPage.sendFeedback(testFeedback)

        Assertions.assertEquals("Спасибо за отзыв.", confirmText)

        driver.quit()
    }
}