package pages

import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.IOSActionHandler

open class BasePage(protected val driver: IOSDriver) {
    private val actionHandler: IOSActionHandler = IOSActionHandler(driver)

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    fun touchAndHold(element: WebElement, duration: Int) = actionHandler.touchAndHold(element, duration)
}