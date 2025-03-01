import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.AlertViewPage
import pages.HomePage

class AlertViewTest : BaseTest() {
    private lateinit var sut: AlertViewPage

    @BeforeMethod
    private fun setUp() = with(HomePage(driver)) {
        sut = openAlertViewPage()
    }

    @AfterMethod
    private fun tearDown() = sut.dispose()

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