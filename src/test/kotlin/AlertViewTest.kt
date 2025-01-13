import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.AlertViewPage
import pages.HomePage

class AlertViewTest : IOSBaseTest() {
    private lateinit var sut: AlertViewPage

    @BeforeMethod
    private fun setUp() = with(HomePage(driver)) {
        sut = openAlertViewPage()
    }

    @Test
    fun testAlertView() = with(sut) {
        entryText("Hello World")
    }

    @Test
    fun testClickOnCancelView() = with(sut) {
        openConfirmationAlert()
        verifyConfirmationText("A message should be a short, complete sentence.")
    }
}