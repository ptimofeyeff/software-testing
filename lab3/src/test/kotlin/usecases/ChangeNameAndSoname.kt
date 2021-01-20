package usecases

import data.TestCredentials
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class ChangeNameAndSoname {

    private val newName = "Pavel"
    private val newSoname = "Timofeev"

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it change name and soname`(driver: WebDriver) {
        val signInPage = MainPage(driver).getSignInPage()
        val authPage = signInPage.getAuthPage(TestCredentials.email, TestCredentials.password)
        val personalSettingsPage = authPage.getPersonalSettingsPage()

        val randomName = newName + (0..10000).random()
        val newCred = personalSettingsPage.setContactField(randomName, newSoname)

        Assertions.assertEquals(randomName, newCred.first)
        Assertions.assertEquals(newSoname, newCred.second)

        driver.quit()
    }

}