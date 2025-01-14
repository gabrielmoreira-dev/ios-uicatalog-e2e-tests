import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.service.local.AppiumDriverLocalService
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeSuite
import java.net.URL
import java.nio.file.Paths

open class BaseTest {
    companion object {
        const val APP_DIR = "src/test/resources/UIKitCatalog.app"
        const val SERVER_URL = "http://127.0.0.1:4723"
    }

    private lateinit var service: AppiumDriverLocalService
    protected lateinit var driver: AppiumDriver

    @BeforeSuite
    protected fun startAppium() {
        service = AppiumDriverLocalService.buildDefaultService().apply { start() }
    }

    @AfterSuite
    protected fun stopAppium() = service.stop()

    @BeforeClass
    protected fun setUpDriver() = DesiredCapabilities().apply {
        val appPath = Paths.get(System.getProperty("user.dir"), APP_DIR).toAbsolutePath().toString()
        setCapability("appium:app", appPath)
        setCapability("platformName", "IOS")
        setCapability("appium:automationName", "XCUITest")
        setCapability("appium:deviceName", "iPhone 15 Pro")
        setCapability("appium:platformVersion", "18.0")
    }.let {
        driver = IOSDriver(URL(SERVER_URL), it)
    }

    @AfterClass
    protected fun dispose() = driver.quit()
}