import io.appium.java_client.AppiumDriver
import io.appium.java_client.service.local.AppiumDriverLocalService
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeSuite
import utils.AppiumDriverWrapper

open class BaseTest {
    private lateinit var service: AppiumDriverLocalService
    protected lateinit var driver: AppiumDriver

    @BeforeSuite
    protected fun startAppium() {
        service = AppiumDriverLocalService.buildDefaultService().apply { start() }
    }

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