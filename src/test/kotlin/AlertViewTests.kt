import io.appium.java_client.AppiumBy
import org.testng.annotations.Test

class AlertViewTests: IOSBaseTest() {
    @Test
    fun testAlertView() {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click()
    }
}