package utils

import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebElement

class IOSActionHandler(private val driver: IOSDriver) {
    fun touchAndHold(element: WebElement, duration: Int): Unit = HashMap<String, Any>().apply {
        put("element", (element as RemoteWebElement).id)
        put("duration", duration)
    }.let {
        driver.executeScript("mobile: touchAndHold", it)
    }
}