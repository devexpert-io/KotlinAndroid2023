package com.devexperto.modulo4.services.ejercicio

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devexperto.modulo4.databinding.ActivityServicesEjercicioBinding

class EjercicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServicesEjercicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServicioEjercicioPlay.setOnClickListener {
            startPlayerService(this)
        }

        binding.btnServicioEjercicioStop.setOnClickListener {
            stopPlayerService(this)
        }
    }

    private fun startPlayerService(context: Context) {
        val intent = Intent(context, PlayerService::class.java)
        intent.action = PlayerService.ACTION_PLAY
        context.startService(intent)
    }

    private fun stopPlayerService(context: Context) {
        val intent = Intent(context, PlayerService::class.java)
        intent.action = PlayerService.ACTION_STOP
        context.startService(intent)
    }

}