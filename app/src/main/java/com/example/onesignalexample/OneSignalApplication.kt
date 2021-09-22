package com.example.onesignalexample

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal

class OneSignalApplication : Application() {
    private val ONESIGNAL_APP_ID = "b1e5a976-d434-4931-a8eb-f47aa624cbf6"
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

    }

}