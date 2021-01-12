package usecases

import data.ArticleTitle
import helpers.RunWithChrome
import helpers.RunWithFirefox
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.openqa.selenium.WebDriver
import pages.MainPage
import java.util.concurrent.TimeUnit

class ReadArticles {

    @ParameterizedTest
    @RunWithChrome
    @RunWithFirefox
    fun `it display text in articles`(driver: WebDriver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        val mainPage = MainPage(driver)

        val resourcePage = mainPage.getResourcePage()
        val earnOnBlogArticle = resourcePage.getArticlePage(ArticleTitle.EARN_ON_BLOG.value).getArticleText()
        driver.navigate().back()
        val siteOptimizationArticle = resourcePage.getArticlePage(ArticleTitle.SITE_OPTIMIZATION.value).getArticleText()

        Assertions.assertEquals(
            "Получать доход от блога можно разными способами. Мы расскажем вам о нескольких моделях и популярных стратегиях монетизации.",
            earnOnBlogArticle
        )
        Assertions.assertEquals(
            "Хотите повысить доход от AdSense? Следуйте этим рекомендациям по оптимизации сайта.",
            siteOptimizationArticle
        )
        driver.quit()
    }
}