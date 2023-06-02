package com.devexperto.modulo4.services.ejemplo2

import android.Manifest
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.devexperto.modulo4.databinding.ActivityServicesEjemplo2Binding

class Ejemplo2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServicesEjemplo2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjemplo2.setOnClickListener {
            startDownloadService(this)
        }
    }

    private fun startDownloadService(context: Context) {
        TODO()
    }
}