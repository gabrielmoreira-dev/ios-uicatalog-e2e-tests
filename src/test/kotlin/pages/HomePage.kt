package pages

import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class HomePage(private val driver: IOSDriver) {
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private lateinit var alertViewsItem: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }

    fun openAlertViewPage() = run {
        alertViewsItem.click()
        AlertViewPage(driver)
    }
}