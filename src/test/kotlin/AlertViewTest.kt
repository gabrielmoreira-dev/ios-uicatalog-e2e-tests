import org.testng.annotations.Test
import pages.HomePage

class AlertViewTest : IOSBaseTest() {
    @Test
    fun testAlertView() {
        HomePage(driver).openAlertViewPage().apply {
            entryText("Hello World")
        }
    }

    @Test
    fun testClickOnCancelView() {
        HomePage(driver).openAlertViewPage().apply {
            openConfirmationAlert()
            verifyConfirmationText("A message should be a short, complete sentence.")
        }
    }
}