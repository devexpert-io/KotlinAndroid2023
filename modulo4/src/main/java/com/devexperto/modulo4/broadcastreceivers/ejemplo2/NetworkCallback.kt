package com.devexperto.modulo4.broadcastreceivers.ejemplo2

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.widget.Toast

// Con ConnectivityManager.NetworkCallback a partir de Android 7 y superiores
class NetworkCallback(private val context: Context) : ConnectivityManager.NetworkCallback() {
    private val connectivityManager: ConnectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    fun register() {
        val networkRequest = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(networkRequest, this)
    }

    fun unregister() {
        connectivityManager.unregisterNetworkCallback(this)
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onAvailable(network: Network) {
        showToast("Conexión a red establecida")
    }

    override fun onLost(network: Network) {
        showToast("Conexión a red perdida")
    }
}
