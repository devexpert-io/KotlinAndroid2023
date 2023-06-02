package com.devexperto.modulo4.broadcastreceivers.ejemplo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityReceiversEjemplo1Binding

class Ejemplo1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReceiversEjemplo1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}