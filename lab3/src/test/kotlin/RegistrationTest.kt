import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.GoogleCreateAccountPage
import pages.MainPage
import pages.RegisterPage
import java.util.concurrent.TimeUnit

class RegistrationTest {

    private val TEST_EMAIL = "jirediv919@aranelab.com"

    @ParameterizedTest
    @RunWithFirefox
    @RunWithChrome
    fun `it send verification code for specified email`(driver: WebDriver) {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)

        MainPage(driver).startWork()
        RegisterPage(driver).registration()

        val confirmCodeText = GoogleCreateAccountPage(driver, TEST_EMAIL).createAccount()

        Assertions.assertEquals("""
            Введите код подтверждения, отправленный на адрес $TEST_EMAIL. Если письма нет во входящих, проверьте папку "Спам".
        """.trimIndent(), confirmCodeText)

        Thread.sleep(1000)
        driver.quit()
    }
}