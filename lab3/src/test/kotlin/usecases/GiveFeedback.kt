package usecases

import data.TestCredentials
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class GiveFeedback {

    private val testFeedback = "testFeedback"

    @RunWithChrome
    @RunWithFirefox
    @ParameterizedTest
    fun `it display thanks text for submitting feedback`(driver: WebDriver) {
        val signInPage = MainPage(driver).getSignInPage()
        val authPage = signInPage.getAuthPage(TestCredentials.email, TestCredentials.password)

        val confirmText = authPage.sendFeedback(testFeedback)

        Assertions.assertEquals("Спасибо за отзыв.", confirmText)

        driver.quit()
    }
}