package utils

import io.appium.java_client.service.local.AppiumDriverLocalService

class AppiumServiceWrapper private constructor() {
    companion object {
        @Volatile
        private var instance: AppiumDriverLocalService? = null

        fun getService() = instance ?: synchronized(this) {
            instance ?: AppiumDriverLocalService.buildDefaultService().also { instance = it }
        }
    }
}