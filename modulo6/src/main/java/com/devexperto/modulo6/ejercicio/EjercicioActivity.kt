package com.devexperto.modulo6.ejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo6.databinding.ActivityEjercicioBinding

class EjercicioActivity : AppCompatActivity() {
    lateinit var binding: ActivityEjercicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLlamar.setOnClickListener {

        }
    }


}