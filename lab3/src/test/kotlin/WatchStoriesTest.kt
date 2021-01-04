import helpers.WebDriverArgumentsProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import org.openqa.selenium.WebDriver
import pages.MainPage

class WatchStoriesTest {

    @ParameterizedTest
    @ArgumentsSource(WebDriverArgumentsProvider::class)
    fun `it playback success stories`(driver: WebDriver) {
        val mainPage = MainPage(driver)
        mainPage.watchSuccessStories()
        Assertions.assertEquals("5", mainPage.currentPlayingTime.text)
    }
}