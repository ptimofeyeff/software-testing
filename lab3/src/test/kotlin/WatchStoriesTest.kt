import helpers.RunWithChrome
import helpers.RunWithFirefox
import helpers.WebDriverTemplateInvocationContextProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import org.openqa.selenium.WebDriver
import pages.MainPage

@ExtendWith(WebDriverTemplateInvocationContextProvider::class)
class WatchStoriesTest {


    @TestTemplate
    @RunWithChrome
    //@RunWithFirefox
    fun `it playback success stories`(driver: WebDriver) {
        val mainPage = MainPage(driver)
        mainPage.watchSuccessStories()
        Assertions.assertEquals("5", mainPage.currentPlayingTime.text)
    }

}