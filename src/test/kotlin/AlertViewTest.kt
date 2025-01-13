import org.testng.annotations.Test
import pages.HomePage

class AlertViewTest : IOSBaseTest() {
    @Test
    fun testAlertView() = with(HomePage(driver).openAlertViewPage()) {
        entryText("Hello World")
    }

    @Test
    fun testClickOnCancelView() = with(HomePage(driver).openAlertViewPage()) {
        openConfirmationAlert()
        verifyConfirmationText("A message should be a short, complete sentence.")
    }
}