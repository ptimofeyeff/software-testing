package helpers

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.platform.commons.support.AnnotationSupport
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.lang.Exception
import java.util.stream.Stream


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(WebDriverArgumentsProvider::class)
annotation class RunWithChrome

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(WebDriverArgumentsProvider::class)
annotation class RunWithFirefox

class WebDriverArgumentsProvider : ArgumentsProvider {

    override fun provideArguments(context: ExtensionContext): Stream<out Arguments> =
        Stream.builder<Arguments>().apply {
            context.testMethod.ifPresent {
                if (AnnotationSupport.isAnnotated(it, RunWithChrome::class.java)) {
                    add(Arguments.of(ChromeDriver()))
                }
                if (AnnotationSupport.isAnnotated(it, RunWithFirefox::class.java)) {
                    add(Arguments.of(FirefoxDriver()))
                }
            }
        }.build()
}

fun waitForClick(element: WebElement) {
    while (true) {
        try {
            element.click()
            break
        } catch (e: Exception) { }
    }
}

fun waitForClickToAnotherPage(driver: WebDriver, xpath: String) {
    try {
        while (true)
            driver.findElement(By.xpath(xpath)).click()
    } catch (e: Exception) { }
}