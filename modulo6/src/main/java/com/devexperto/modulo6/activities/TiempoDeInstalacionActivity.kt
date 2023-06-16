package com.devexperto.modulo6.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo6.databinding.ActivityTiempoDeInstalacionBinding

class TiempoDeInstalacionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeInstalacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeInstalacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEstadoDeRed.setOnClickListener {

        }
        binding.btnVibracion.setOnClickListener {

        }
        binding.btnAccederAInternet.setOnClickListener {

        }
    }
}