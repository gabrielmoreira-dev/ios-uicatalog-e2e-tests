import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.HomePage
import pages.PickerViewPage

class PickerViewTest : BaseTest() {
    private lateinit var sut: PickerViewPage

    @BeforeMethod
    private fun setUp() = with(HomePage(driver)) {
        sut = openPickerViewPage()
    }

    @Test
    fun testPickerView() = with(sut) {
        serRGBColors(red = "80", green = "220", blue = "105")
        verifyRGBColors(arrayOf("80", "220", "105"))
    }
}