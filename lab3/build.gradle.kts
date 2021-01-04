import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}

group = "me.ptimofeev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:3.141.59")
}

tasks.test {
    useJUnitPlatform()
    systemProperties(
        "webdriver.chrome.driver" to "/Users/ptimofeev/dev/current-sem/software-testing/chromedriver",
        "webdriver.gecko.driver" to "/Users/ptimofeev/dev/current-sem/software-testing/geckodriver"
    )
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}