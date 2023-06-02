package com.devexperto.modulo4.services.ejemplo3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityServicesEjemplo3Binding

class Ejemplo3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServicesEjemplo3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjemplo1.setOnClickListener {
            TODO()
        }
    }

}