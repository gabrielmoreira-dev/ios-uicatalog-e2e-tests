package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.testng.Assert

class AlertViewPage(driver: AppiumDriver) : BasePage(driver) {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
    private lateinit var textEntryItem: WebElement

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    private lateinit var textField: WebElement

    @iOSXCUITFindBy(accessibility = "OK")
    private lateinit var okButton: WebElement

    @iOSXCUITFindBy(accessibility = "Confirm / Cancel")
    private lateinit var confirmationItem: WebElement

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private lateinit var confirmationTextView: WebElement

    fun entryText(value: String) {
        textEntryItem.click()
        textField.sendKeys(value)
        okButton.click()
    }

    fun openConfirmationAlert() = confirmationItem.click()

    fun verifyConfirmationText(expected: String) = Assert.assertEquals(confirmationTextView.text, expected)
}