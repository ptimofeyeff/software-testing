package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class CheckExistingSolutions {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it display text about existing solutions`(driver: WebDriver) {

        val solutionsPage = MainPage(driver).getSolutionsPage()

        Assertions.assertEquals(
            solutionsPage.getAdvantageHeader(solutionsPage.autoAdsDetailBtn, 4),
            "Оптимизация для мобильных устройств"
        )

        driver.navigate().back()

        Assertions.assertEquals(
            solutionsPage.getAdvantageHeader(solutionsPage.responsiveAdsDetailBtn, 1),
            "Возможное увеличение дохода"
        )

        driver.quit()
    }

}