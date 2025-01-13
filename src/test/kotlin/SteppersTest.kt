import org.testng.annotations.Test
import pages.HomePage

class SteppersTest : IOSBaseTest() {
    @Test
    fun testLogPress() = with(HomePage(driver).openSteppersPage()) {
        holdIncrementButton()
        verifyValue()
    }
}