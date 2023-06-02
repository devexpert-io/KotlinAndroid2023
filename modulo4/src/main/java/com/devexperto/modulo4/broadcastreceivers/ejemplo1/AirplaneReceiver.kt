package com.devexperto.modulo4.broadcastreceivers.ejemplo1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)

        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Modo avión habilitado", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Modo avión deshabilitado", Toast.LENGTH_LONG).show()
        }
    }
}