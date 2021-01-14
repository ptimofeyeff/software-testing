package helpers

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.platform.commons.support.AnnotationSupport
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
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