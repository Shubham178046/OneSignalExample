package com.example.onesignalexample

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.os.PowerManager
import com.onesignal.OneSignal

class OneSignalApplication : Application() {
    private val ONESIGNAL_APP_ID = "b1e5a976-d434-4931-a8eb-f47aa624cbf6"
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.setNotificationWillShowInForegroundHandler(
            NotificationWillShowInForeground(
                applicationContext
            )
        )
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID);

    }
}