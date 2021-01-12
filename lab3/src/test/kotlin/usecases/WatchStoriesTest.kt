package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class WatchStoriesTest {

    @Disabled
    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it playback success stories`(driver: WebDriver) {
        val mainPage = MainPage(driver)
        mainPage.watchSuccessStories()
        Assertions.assertEquals("5", mainPage.currentPlayingTime.text)
    }
}
