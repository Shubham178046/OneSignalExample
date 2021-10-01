package com.example.onesignalexample

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log

import org.json.JSONObject

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.PowerManager

import android.text.style.ForegroundColorSpan

import android.text.SpannableString

import android.text.Spannable
import androidx.core.app.NotificationCompat

import java.math.BigInteger

import com.onesignal.OSMutableNotification

import com.onesignal.OSNotification

import com.onesignal.OSNotificationReceivedEvent

import com.onesignal.OneSignal.OSRemoteNotificationReceivedHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NotificationServiceExtension : OSRemoteNotificationReceivedHandler,
    MediaPlayer.OnCompletionListener {
    var mMediaPlayer: MediaPlayer? = null
    override fun remoteNotificationReceived(
        context: Context?,
        notificationReceivedEvent: OSNotificationReceivedEvent
    ) {
        Log.d("TAG", "remoteNotificationReceived: " + "Call")
        Log.d("TAG", "remoteNotificationReceived: " + notificationReceivedEvent.notification.notificationId)
        // val filter = IntentFilter()
        notificationReceivedEvent.notification.notificationId
        mMediaPlayer = MediaPlayer.create(context, R.raw.song)
        mMediaPlayer!!.setOnCompletionListener(this);
        mMediaPlayer!!.setWakeMode(context, PowerManager.PARTIAL_WAKE_LOCK)
        CoroutineScope(Dispatchers.Main).launch {
         //   mMediaPlayer?.start()
        }
    }

    override fun onCompletion(p0: MediaPlayer?) {
        mMediaPlayer!!.stop()
    }
}