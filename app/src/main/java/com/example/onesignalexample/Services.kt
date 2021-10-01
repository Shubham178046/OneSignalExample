package com.example.onesignalexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class Services : Service(), MediaPlayer.OnCompletionListener {
    private val ACTION_PLAY: String = "com.musicalarm.action.PLAY"
    private var mMediaPlayer: MediaPlayer? = null
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action: String = intent!!.action!!

        mMediaPlayer = MediaPlayer.create(this, R.raw.song)
        mMediaPlayer!!.setOnCompletionListener(this);
        mMediaPlayer!!.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK)
        when (action) {
            ACTION_PLAY -> {
                CoroutineScope(Dispatchers.Main).launch {
                    mMediaPlayer?.start()
                }
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
        }
    }

    override fun onCompletion(p0: MediaPlayer?) {
        stopAlarmSound()
    }
}