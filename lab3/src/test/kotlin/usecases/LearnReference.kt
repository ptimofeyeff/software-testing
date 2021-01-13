package usecases

import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage

class LearnReference {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it display reference article`(driver: WebDriver) {

        val mainPage = MainPage(driver)
        val referencePage = mainPage.getReferencePage()
        val siteManagementPage = referencePage.getReferenceArticle("Управление аккаунтом", "Управление сайтом")
        val siteManagementText = siteManagementPage.getArticleText()

        driver.navigate().back()
        val rulePage = referencePage.getReferenceArticle("Правила", "Руководство для начинающих")
        val ruleText = rulePage.getArticleText()

        Assertions.assertEquals("Как управлять сайтами в AdSense", siteManagementText)
        Assertions.assertEquals("Правила AdSense: руководство для начинающих", ruleText)

        driver.quit()
    }
}