package com.devexperto.modulo4.services.ejercicio

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.devexperto.modulo4.R

class PlayerService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.dualipa)
    }

    override fun onBind(intent: Intent): IBinder? = null

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

}