import io.appium.java_client.AppiumBy
import org.openqa.selenium.remote.RemoteWebElement
import org.testng.Assert
import org.testng.annotations.Test

class SteppersTest : IOSBaseTest() {
    @Test
    fun testLogPress() {
        val text: String
        val params = HashMap<String, Any>()
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click()
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][1]")).let {
            params.apply {
                put("element", (it as RemoteWebElement).id)
                put("duration", 5)
            }
        }

        driver.apply {
            executeScript("mobile: touchAndHold", params)
            findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"10\"`]")).let {
                text = it.text
            }
        }

        Assert.assertEquals(text, "10")
    }
}