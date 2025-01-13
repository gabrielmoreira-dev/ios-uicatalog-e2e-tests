package pages

import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.testng.Assert
import utils.IOSActionHandler

class SteppersPage(driver: IOSDriver) {
    private val actionHandler: IOSActionHandler = IOSActionHandler(driver)

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][1]")
    private lateinit var incrementButton: WebElement

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"10\"`]")
    private lateinit var valueTextView: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    fun holdIncrementButton() = actionHandler.touchAndHold(incrementButton, 5)

    fun verifyValue() = Assert.assertEquals(valueTextView.text, "10")
}