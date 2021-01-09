package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.EmailVerifyPage
import pages.GoogleCreateAccountPage
import pages.MainPage
import pages.RegisterPage

class Registration {

    private val testName = "Pavel"
    private val testSoname = "Timofeev"
    private val testEmail = "labTest@test.com"
    private val testPassword = "testPassword"
    private val targetSiteUrl = "testLab.com"

    @ParameterizedTest
    @RunWithFirefox
    @RunWithChrome
    fun `it send verification code for specified email`(driver: WebDriver) {

        MainPage(driver).startWork()
        RegisterPage(driver, targetSiteUrl, testEmail).registration()
        GoogleCreateAccountPage(driver, testName, testSoname, testPassword, testEmail).createAccount()

        val confirmText = EmailVerifyPage(driver).getConfirmationText()
        Assertions.assertEquals(
            """Введите код подтверждения, отправленный на адрес $testEmail. Если письма нет во входящих, проверьте папку "Спам".""",
            confirmText
        )
        Thread.sleep(1000)
        driver.quit()
    }
}