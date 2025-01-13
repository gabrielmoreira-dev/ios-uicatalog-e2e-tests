import org.testng.annotations.Test
import pages.HomePage

class SteppersTest : IOSBaseTest() {
    @Test
    fun testLogPress() = HomePage(driver).openSteppersPage().run {
        holdIncrementButton()
        verifyValue()
    }
}