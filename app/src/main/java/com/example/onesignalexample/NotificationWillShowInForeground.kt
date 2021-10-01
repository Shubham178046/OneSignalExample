package com.example.onesignalexample

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.PowerManager
import android.util.Log
import com.onesignal.OSNotificationReceivedEvent
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationWillShowInForeground(val context: Context) : OneSignal.OSNotificationWillShowInForegroundHandler,
    MediaPlayer.OnCompletionListener {
    var mMediaPlayer: MediaPlayer? = null
    override fun notificationWillShowInForeground(notificationReceivedEvent: OSNotificationReceivedEvent?) {
        Log.d("TAG", "notificationWillShowInForeground: " + "Call")
       /* mMediaPlayer = MediaPlayer.create(context, R.raw.song)
        mMediaPlayer!!.setOnCompletionListener(this);
        mMediaPlayer!!.setWakeMode(
            context,
            PowerManager.PARTIAL_WAKE_LOCK
        )
        CoroutineScope(Dispatchers.Main).launch {
            mMediaPlayer?.start()
        }*/
        val intent = Intent(context, Services::class.java)
        intent.action = "com.musicalarm.action.PLAY"
        if (context.isMyServiceRunning(context, Services::class.java)) {
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

    override fun onCompletion(p0: MediaPlayer?) {
        context.stopAlarmSound()
    }
}