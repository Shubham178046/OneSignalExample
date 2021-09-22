package com.example.onesignalexample

import android.app.ActivityManager
import android.content.Context
import android.content.Intent

fun Context.stopAlarmSound() {
    val intent = Intent(this, Services::class.java)
    stopService(intent)
}

fun  Context.isMyServiceRunning(context: Context, serviceClass: Class<*>): Boolean {
    val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
    for (service in manager!!.getRunningServices(Int.MAX_VALUE)) {
        if (serviceClass.name == service.service.className) {
            return true
        }
    }
    return false
}

