import org.testng.annotations.Test
import pages.HomePage

class AlertViewTest : IOSBaseTest() {
    @Test
    fun testAlertView() = HomePage(driver).openAlertViewPage().run {
        entryText("Hello World")
    }

    @Test
    fun testClickOnCancelView() = HomePage(driver).openAlertViewPage().run {
        openConfirmationAlert()
        verifyConfirmationText("A message should be a short, complete sentence.")
    }
}