import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.HomePage
import pages.SteppersPage

class SteppersTest : IOSBaseTest() {
    private lateinit var sut: SteppersPage

    @BeforeMethod
    private fun setUp() = with(HomePage(driver)) {
        sut = openSteppersPage()
    }

    @Test
    fun testLogPress() = with(sut) {
        holdIncrementButton()
        verifyValue()
    }
}