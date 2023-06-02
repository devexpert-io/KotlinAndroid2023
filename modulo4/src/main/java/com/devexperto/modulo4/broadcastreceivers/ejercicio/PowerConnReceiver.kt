package com.devexperto.modulo4.broadcastreceivers.ejercicio

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PowerConnReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isConnected = intent.action.equals(Intent.ACTION_POWER_CONNECTED)
        if (isConnected) {
            Toast.makeText(context, "Cable de alimentación conectado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Cable de alimentación desconectado", Toast.LENGTH_SHORT).show()
        }
    }
}