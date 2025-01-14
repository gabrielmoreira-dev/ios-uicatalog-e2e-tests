package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

class HomePage(driver: AppiumDriver) : BasePage(driver) {
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private lateinit var alertViewsItem: WebElement

    @iOSXCUITFindBy(accessibility = "Picker View")
    private lateinit var pickerViewItem: WebElement

    @iOSXCUITFindBy(accessibility = "Steppers")
    private lateinit var steppersItem: WebElement

    fun openAlertViewPage() = run {
        alertViewsItem.click()
        AlertViewPage(driver)
    }

    fun openPickerViewPage() = run {
        pickerViewItem.click()
        PickerViewPage(driver)
    }

    fun openSteppersPage() = run {
        steppersItem.click()
        SteppersPage(driver)
    }
}