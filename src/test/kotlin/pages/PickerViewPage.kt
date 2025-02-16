package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.testng.Assert

class PickerViewPage(driver: AppiumDriver) : BasePage(driver) {
    @iOSXCUITFindBy(accessibility = "Red color component value")
    private lateinit var redPicker: WebElement

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private lateinit var greenPicker: WebElement

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private lateinit var bluePicker: WebElement

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")
    private lateinit var backButton: WebElement

    fun serRGBColors(red: String, green: String, blue: String) {
        redPicker.sendKeys(red)
        greenPicker.sendKeys(green)
        bluePicker.sendKeys(blue)
    }

    fun verifyRGBColors(expected: Array<String>) =
        Assert.assertEquals(arrayOf(redPicker.text, greenPicker.text, bluePicker.text), expected)

    fun dispose() = backButton.click()
}