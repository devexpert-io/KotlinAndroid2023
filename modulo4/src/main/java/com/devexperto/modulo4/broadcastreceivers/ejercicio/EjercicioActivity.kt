package com.devexperto.modulo4.broadcastreceivers.ejercicio

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityReceiversEjercicioBinding

class EjercicioActivity : AppCompatActivity() {
    lateinit var powerConnReceiver: PowerConnReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReceiversEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        powerConnReceiver = PowerConnReceiver()
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(powerConnReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(powerConnReceiver)
    }
}