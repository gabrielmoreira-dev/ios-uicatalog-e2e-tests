import io.appium.java_client.AppiumBy
import org.testng.Assert
import org.testng.annotations.Test

class AlertViewTests : IOSBaseTest() {
    @Test
    fun testAlertView() {
        driver.apply {
            findElement(AppiumBy.accessibilityId("Alert Views")).click()
            findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")).click()
            findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField")).sendKeys("Hello World")
            findElement(AppiumBy.accessibilityId("OK")).click()
        }
    }

    @Test
    fun testClickOnCancelView() {
        val text: String
        driver.apply {
            findElement(AppiumBy.accessibilityId("Alert Views")).click()
            findElement(AppiumBy.accessibilityId("Confirm / Cancel")).click()
            findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).let {
                text = it.text
            }
        }
        Assert.assertEquals(text, "A message should be a short, complete sentence.")
    }
}