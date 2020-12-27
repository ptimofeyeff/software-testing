package helpers

import org.junit.jupiter.api.extension.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.lang.reflect.Method
import java.util.stream.Stream


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RunWithChrome

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RunWithFirefox

class WebDriverTemplateInvocationContextProvider : TestTemplateInvocationContextProvider{

    init {
        System.setProperty("webdriver.chrome.driver", "/Users/ptimofeev/dev/current-sem/software-testing/chromedriver")
        System.setProperty("webdriver.gecko.driver", "/Users/ptimofeev/dev/current-sem/software-testing/geckodriver")
    }

    override fun supportsTestTemplate(context: ExtensionContext?) = true

    override fun provideTestTemplateInvocationContexts(context: ExtensionContext): Stream<TestTemplateInvocationContext> =
        Stream.builder<TestTemplateInvocationContext>().apply {
            if (context.testMethod.map { it.getAnnotationsByType(RunWithChrome::class.java).isNotEmpty() }.orElse(false))
                add(invocationContext(ChromeDriver::class.java))

            if (context.testMethod.map { it.getAnnotationsByType(RunWithFirefox::class.java).isNotEmpty() }.orElse(false))
                add(invocationContext(FirefoxDriver::class.java))
        }.build()

    private fun invocationContext(driverClass: Class<out WebDriver>): TestTemplateInvocationContext {
        return object : TestTemplateInvocationContext {
            override fun getDisplayName(invocationIndex: Int) = driverClass.simpleName

            override fun getAdditionalExtensions(): List<Extension> {
                return listOf(object : ParameterResolver {
                    override fun supportsParameter(paramCtx: ParameterContext, extensionCtx: ExtensionContext) =
                        paramCtx.parameter.type == WebDriver::class.java
                    override fun resolveParameter(paramCtx: ParameterContext, extensionCtx: ExtensionContext) =
                        driverClass.getConstructor().newInstance()
                }, object : InvocationInterceptor {
                    override fun interceptTestTemplateMethod(
                        invocation: InvocationInterceptor.Invocation<Void>,
                        invocationContext: ReflectiveInvocationContext<Method>,
                        extensionContext: ExtensionContext?
                    ) {
                        invocation.proceed()
                        invocationContext.arguments.filterIsInstance<WebDriver>().first().quit()
                    }
                })
            }
        }
    }

}

fun WebDriver.findElementByXpath(xPath: String): WebElement = this.findElement(By.xpath(xPath))