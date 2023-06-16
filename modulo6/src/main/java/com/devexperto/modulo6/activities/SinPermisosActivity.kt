package com.devexperto.modulo6.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo6.databinding.ActivitySinPermisosBinding

class SinPermisosActivity : AppCompatActivity() {
    lateinit var binding: ActivitySinPermisosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySinPermisosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMarcadoTelefonico.setOnClickListener {

        }
        binding.btnCompartirTexto.setOnClickListener {

        }
        binding.btnAbrirCamara.setOnClickListener {

        }
    }
}