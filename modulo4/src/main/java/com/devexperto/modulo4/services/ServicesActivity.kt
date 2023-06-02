package com.devexperto.modulo4.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo4.databinding.ActivityServicesBinding
import com.devexperto.modulo4.services.ejemplo1.Ejemplo1Activity
import com.devexperto.modulo4.services.ejemplo2.Ejemplo2Activity
import com.devexperto.modulo4.services.ejemplo3.Ejemplo3Activity
import com.devexperto.modulo4.services.ejercicio.EjercicioActivity

class ServicesActivity : AppCompatActivity() {
    lateinit var binding: ActivityServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjemplo1.setOnClickListener {
            startActivity(Intent(this, Ejemplo1Activity::class.java))
        }
        binding.btnServicioEjemplo2.setOnClickListener {
            startActivity(Intent(this, Ejemplo2Activity::class.java))
        }
        binding.btnServicioEjemplo3.setOnClickListener {
            startActivity(Intent(this, Ejemplo3Activity::class.java))
        }
        binding.btnServicioEjercicio.setOnClickListener {
            startActivity(Intent(this, EjercicioActivity::class.java))
        }
    }
}