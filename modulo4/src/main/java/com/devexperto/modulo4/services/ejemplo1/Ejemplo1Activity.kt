package com.devexperto.modulo4.services.ejemplo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityServicesEjemplo1Binding

class Ejemplo1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServicesEjemplo1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjemplo1.setOnClickListener {
            backgroundProcessing()
        }

        MyDataHolder.textLiveData.observe(this) { newText ->
            binding.tvSeEjemplo1Resultado.text = newText
        }
    }

    private fun backgroundProcessing() {
        TODO()
    }
}