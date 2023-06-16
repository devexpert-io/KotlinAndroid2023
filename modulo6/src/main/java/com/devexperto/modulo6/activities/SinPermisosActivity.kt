package com.devexperto.modulo6.activities

import android.content.Intent
import android.net.Uri
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
            abrirMarcadoTelefonico()
        }
        binding.btnCompartirTexto.setOnClickListener {
            compartirTexto("Hola desde DevExperto")
        }
        binding.btnAbrirCamara.setOnClickListener {

        }
    }

    private fun abrirMarcadoTelefonico() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:77752810")
        startActivity(intent)
    }

    private fun compartirTexto(texto: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, texto)
        startActivity(Intent.createChooser(intent, "Compartir"))
    }
}