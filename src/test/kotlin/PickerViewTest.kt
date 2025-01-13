import org.testng.annotations.Test
import pages.HomePage

class PickerViewTest : IOSBaseTest() {
    @Test
    fun testPickerView() = with(HomePage(driver).openPickerViewPage()) {
        serRGBColors(red = "80", green = "220", blue = "105")
        verifyRGBColors(arrayOf("80", "220", "105"))
    }
}