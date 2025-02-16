import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.HomePage
import pages.SteppersPage

class SteppersTest : BaseTest() {
    private lateinit var sut: SteppersPage

    @BeforeMethod
    private fun setUp() = with(HomePage(driver)) {
        sut = openSteppersPage()
    }

    @AfterMethod
    private fun tearDown() = sut.dispose()

    @Test
    fun testLogPress() = with(sut) {
        holdIncrementButton()
        verifyValue()
    }
}