import io.appium.java_client.AppiumDriver
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeSuite
import utils.AppiumDriverWrapper
import utils.AppiumServiceWrapper

open class BaseTest {
    private val service = AppiumServiceWrapper.getService()
    protected lateinit var driver: AppiumDriver

    @BeforeSuite
    protected fun startAppium() = service.start()

    @BeforeClass
    protected fun setUpClass() {
        driver = AppiumDriverWrapper.getDriver()
    }

    @AfterSuite
    protected fun dispose() {
        driver.quit()
        service.stop()
    }
}