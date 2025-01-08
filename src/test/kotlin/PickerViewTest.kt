import io.appium.java_client.AppiumBy
import org.testng.Assert
import org.testng.annotations.Test

class PickerViewTest : IOSBaseTest() {
    @Test
    fun testPickerView() {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click()
        val redPicker = driver.findElement(AppiumBy.accessibilityId("Red color component value"))
        val greenPicker = driver.findElement(AppiumBy.accessibilityId("Green color component value"))
        val bluePicker = driver.findElement(AppiumBy.accessibilityId("Blue color component value"))

        redPicker.sendKeys("80")
        greenPicker.sendKeys("220")
        bluePicker.sendKeys("105")

        Assert.assertEquals(redPicker.text, "80")
        Assert.assertEquals(greenPicker.text, "220")
        Assert.assertEquals(bluePicker.text, "105")
    }
}