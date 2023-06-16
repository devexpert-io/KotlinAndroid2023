package com.devexperto.modulo6.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo6.databinding.ActivityTiempoDeEjecucionBinding

class TiempoDeEjecucionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeEjecucionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeEjecucionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccederContactos.setOnClickListener {

        }
        binding.btnAccederUbicacion.setOnClickListener {

        }
        binding.btnAccederMultiplesPermisos.setOnClickListener {

        }
        binding.btnAccederCamara.setOnClickListener {

        }
    }
}