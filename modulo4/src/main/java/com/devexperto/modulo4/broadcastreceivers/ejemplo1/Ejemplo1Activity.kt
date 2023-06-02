package com.devexperto.modulo4.broadcastreceivers.ejemplo1

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityReceiversEjemplo1Binding

class Ejemplo1Activity : AppCompatActivity() {

    lateinit var receiver: AirplaneReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReceiversEjemplo1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        receiver = AirplaneReceiver()

        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}