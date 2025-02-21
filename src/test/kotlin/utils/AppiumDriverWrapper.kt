package utils

import io.appium.java_client.AppiumDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import java.net.URL
import java.nio.file.Paths

class AppiumDriverWrapper private constructor() {
    companion object {
        private const val AUTOMATION_NAME = "XCUITest"
        private const val USER_DIR = "user.dir"
        private const val APP_DIR = "src/test/resources/UIKitCatalog.app"
        private const val PLATFORM_NAME = "IOS"
        private const val PLATFORM_VERSION = "18.0"
        private const val DEVICE_NAME = "iPhone 15 Pro"
        private const val SERVER_URL = "http://127.0.0.1:4723"

        @Volatile
        private var instance: AppiumDriver? = null

        fun getDriver() = instance ?: synchronized(this) {
            instance ?: getIOSDriver().also { instance = it }
        }

        private fun getIOSDriver(): IOSDriver = with(XCUITestOptions()) {
            setAutomationName(AUTOMATION_NAME)
            setApp(Paths.get(System.getProperty(USER_DIR), APP_DIR).toAbsolutePath().toString())
            setPlatformName(PLATFORM_NAME)
            setPlatformVersion(PLATFORM_VERSION)
            setDeviceName(DEVICE_NAME)
            return IOSDriver(URL(SERVER_URL), this)
        }
    }
}