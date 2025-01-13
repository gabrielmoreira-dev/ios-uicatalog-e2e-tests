package pages

import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class HomePage(private val driver: IOSDriver) {
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private lateinit var alertViewsItem: WebElement

    @iOSXCUITFindBy(accessibility = "Picker View")
    private lateinit var pickerViewItem: WebElement

    @iOSXCUITFindBy(accessibility = "Steppers")
    private lateinit var steppersItem: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

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