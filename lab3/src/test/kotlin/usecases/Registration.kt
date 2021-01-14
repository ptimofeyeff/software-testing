package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class Registration {

    private val testName = "Pavel"
    private val testSoname = "Timofeev"
    private val testEmail = "labTest4@test.com"
    private val testPassword = "testPassword"
    private val targetSiteUrl = "testLab.com"

    @ParameterizedTest
    @RunWithFirefox
    @RunWithChrome
    fun registerFromStartWorkButton(driver: WebDriver) {

        val registerPage = MainPage(driver).startWork()
        val createAccountPage = registerPage.registration(targetSiteUrl, testEmail)
        val emailVerifyPage = createAccountPage.createAccount(testName, testSoname, testPassword, testEmail)

        val confirmText = emailVerifyPage.getConfirmationText()
        Assertions.assertEquals(
            """Введите код подтверждения, отправленный на адрес $testEmail. Если письма нет во входящих, проверьте папку "Спам".""",
            confirmText
        )

        driver.quit()
    }

    @ParameterizedTest
    @RunWithFirefox
    @RunWithChrome
    fun registerFromSignInForm(driver: WebDriver) {

        val signInPage = MainPage(driver).getSignInPage()
        val googleCreateAccountPage = signInPage.getCreateAccountPage()
        val emailVerifyPage = googleCreateAccountPage.createAccount(testName, testSoname, testPassword, testEmail)
        val confirmText = emailVerifyPage.getConfirmationText()

        Assertions.assertEquals(
            """Введите код подтверждения, отправленный на адрес $testEmail. Если письма нет во входящих, проверьте папку "Спам".""",
            confirmText
        )

        driver.quit()
    }
}