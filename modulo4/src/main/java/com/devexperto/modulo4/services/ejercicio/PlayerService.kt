package com.devexperto.modulo4.services.ejercicio

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.devexperto.modulo4.R

class PlayerService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    private val binder: LocalBinder = LocalBinder()

    inner class LocalBinder : Binder() {
        @Suppress("unused")
        fun getService(): PlayerService = this@PlayerService
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.dualipa)
    }

    override fun onBind(intent: Intent): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                ACTION_PLAY -> playMusic()
                ACTION_STOP -> stopMusic()
            }
        }
        return START_STICKY
    }

    private fun playMusic() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    private fun stopMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.prepare()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    companion object {
        const val ACTION_PLAY = "com.devexperto.modulo4.action.PLAY"
        const val ACTION_STOP = "com.devexperto.modulo4.action.STOP"
    }
}