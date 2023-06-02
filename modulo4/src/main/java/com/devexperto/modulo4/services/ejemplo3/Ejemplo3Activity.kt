package com.devexperto.modulo4.services.ejemplo3

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityServicesEjemplo3Binding

class Ejemplo3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityServicesEjemplo3Binding
    private lateinit var myService: MyService
    private var isBind = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesEjemplo3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjemplo1.setOnClickListener {
            getServiceMessage()
        }
    }

    private var serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val localService = service as MyService.LocalService
            myService = localService.service
            isBind = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBind = false
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MyService::class.java)
        bindService(intent, serviceConnection, BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        if (isBind) {
            unbindService(serviceConnection)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getServiceMessage() {
        val firstMessage = myService.firstMessage
        val secondMessage = myService.secondMessage
        binding.tvSeEjemplo3Resultado.text = firstMessage + secondMessage
        Toast.makeText(this@Ejemplo3Activity, "$firstMessage $secondMessage", Toast.LENGTH_LONG)
            .show()
    }
}