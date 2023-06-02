package com.devexperto.modulo4.services.ejercicio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityServicesEjercicioBinding

class EjercicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServicesEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjercicioPlay.setOnClickListener {
            TODO()
        }

        binding.btnServicioEjercicioStop.setOnClickListener {
            TODO()
        }
    }

}