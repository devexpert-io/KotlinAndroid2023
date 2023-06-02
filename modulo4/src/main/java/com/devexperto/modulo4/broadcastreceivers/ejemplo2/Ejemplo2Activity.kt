package com.devexperto.modulo4.broadcastreceivers.ejemplo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo4.databinding.ActivityReceiversEjemplo2Binding

class Ejemplo2Activity : AppCompatActivity() {
    lateinit var binding: ActivityReceiversEjemplo2Binding

    // Con BroadcastReceiver
    // private lateinit var networkChangeReceiver: Receiver
    // private lateinit var intentFilter: IntentFilter

    // Con ConnectivityManager.NetworkCallback a partir de Android 12 y superiores
    private lateinit var networkCallback: NetworkCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiversEjemplo2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Con BroadcastReceiver
        // networkChangeReceiver = Receiver()
        // intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

        // Con ConnectivityManager.NetworkCallback a partir de Android 7 y superiores
        networkCallback = NetworkCallback(this)
        networkCallback.register()
    }

    // Con BroadcastReceiver
    /*override fun onResume() {
        super.onResume()
        registerReceiver(networkChangeReceiver, intentFilter)
    }*/

    // Con BroadcastReceiver
    /*override fun onPause() {
        super.onPause()
        unregisterReceiver(networkChangeReceiver)
    }*/

    // Con ConnectivityManager.NetworkCallback a partir de Android 7 y superiores
    override fun onDestroy() {
        super.onDestroy()
        networkCallback.unregister()
    }
}