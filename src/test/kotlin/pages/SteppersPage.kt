package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.testng.Assert

class SteppersPage(driver: AppiumDriver) : BasePage(driver) {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][1]")
    private lateinit var incrementButton: WebElement

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"10\"`]")
    private lateinit var valueTextView: WebElement

    fun holdIncrementButton() = touchAndHold(incrementButton, 5)

    fun verifyValue() = Assert.assertEquals(valueTextView.text, "10")
}