package com.devexperto.modulo4.broadcastreceivers.ejemplo2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        // Receiver funcional para versiones menores a Android 7 (N), para superiores se debe usar NetworkCallback

        if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val networkInfo = intent.getParcelableExtra<NetworkInfo>(ConnectivityManager.EXTRA_NETWORK_INFO)
            if (networkInfo != null && networkInfo.isConnected) {
                // Se detectó una conexión de red
                Toast.makeText(context, "Conexión de red establecida ---", Toast.LENGTH_SHORT).show()
            } else {
                // No hay conexión de red
                Toast.makeText(context, "Conexión de red perdida ---", Toast.LENGTH_SHORT).show()
            }
        }
    }

}