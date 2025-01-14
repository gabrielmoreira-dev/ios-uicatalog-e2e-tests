package utils

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

class IOSActionHandler(private val driver: AppiumDriver) {
    fun touchAndHold(element: WebElement, duration: Int): Unit = HashMap<String, Any>().apply {
        put("element", (element as RemoteWebElement).id)
        put("duration", duration)
    }.let {
        driver.executeScript("mobile: touchAndHold", it)
    }
}