package com.devexperto.modulo4.broadcastreceivers.ejercicio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityReceiversEjercicioBinding

class EjercicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReceiversEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}