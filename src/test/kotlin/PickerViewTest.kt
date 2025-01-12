import org.testng.annotations.Test
import pages.HomePage

class PickerViewTest : IOSBaseTest() {
    @Test
    fun testPickerView() = HomePage(driver).openPickerViewPage().run {
        serRGBColors(red = "80", green = "220", blue = "105")
        verifyRGBColors(arrayOf("80", "220", "105"))
    }
}