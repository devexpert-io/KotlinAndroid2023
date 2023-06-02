package com.devexperto.modulo4.broadcastreceivers.ejemplo3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityReceiversEjemplo3Binding

class Ejemplo3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReceiversEjemplo3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        MyDataHolder.textLiveData.observe(this) { newText ->
            binding.tvResultado.text = newText
        }
    }

}