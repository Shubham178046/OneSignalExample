package com.example.onesignalexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

class OneSignalReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        val intent = Intent(context, Services::class.java)
        intent.action = "com.musicalarm.action.PLAY"
        if (context!!.isMyServiceRunning(context, Services::class.java)) {
            context.stopAlarmSound()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }
    }
}