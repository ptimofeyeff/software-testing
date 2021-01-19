package usecases

import data.TestCredentials
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class Registration {

    @ParameterizedTest
    @RunWithFirefox
    @RunWithChrome
    fun registerFromStartWorkButton(driver: WebDriver) {

        val registerPage = MainPage(driver).startWork()
        val createAccountPage = registerPage.registration(TestCredentials.siteUrl, TestCredentials.nonRegEmail)
        val emailVerifyPage = createAccountPage.createAccount(
            TestCredentials.name,
            TestCredentials.soname,
            TestCredentials.password,
            TestCredentials.nonRegEmail
        )

        val confirmText = emailVerifyPage.getConfirmationText()
        Assertions.assertEquals(
            """Введите код подтверждения, отправленный на адрес ${TestCredentials.nonRegEmail}. Если письма нет во входящих, проверьте папку "Спам".""",
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
        val emailVerifyPage = googleCreateAccountPage.createAccount(
            TestCredentials.name,
            TestCredentials.soname,
            TestCredentials.password,
            TestCredentials.nonRegEmail
        )
        val confirmText = emailVerifyPage.getConfirmationText()

        Assertions.assertEquals(
            """Введите код подтверждения, отправленный на адрес ${TestCredentials.nonRegEmail}. Если письма нет во входящих, проверьте папку "Спам".""",
            confirmText
        )

        driver.quit()
    }
}