package com.example.onesignalexample

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

import org.json.JSONObject

import android.graphics.Color
import android.os.Build

import android.text.style.ForegroundColorSpan

import android.text.SpannableString

import android.text.Spannable
import androidx.core.app.NotificationCompat

import java.math.BigInteger

import com.onesignal.OSMutableNotification

import com.onesignal.OSNotification

import com.onesignal.OSNotificationReceivedEvent

import com.onesignal.OneSignal.OSRemoteNotificationReceivedHandler


class NotificationServiceExtension : OSRemoteNotificationReceivedHandler {
    override fun remoteNotificationReceived(
        context: Context?,
        notificationReceivedEvent: OSNotificationReceivedEvent
    ) {
        Log.d("TAG", "remoteNotificationReceived: "+"Call")
       // val filter = IntentFilter()

    }
}