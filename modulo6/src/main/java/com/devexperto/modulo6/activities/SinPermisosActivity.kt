package com.devexperto.modulo6.activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BundleCompat
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
            abrirCamara()
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

    private fun abrirCamara() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            galleryActivityResultLauncher.launch(takePictureIntent)
        } catch (e: ActivityNotFoundException) {
            Log.e("SinPermisosActivity", "No se pudo abrir la cámara", e)
        }
    }

    private val galleryActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val imageBitmap = data?.extras?.let {
                    BundleCompat.getParcelable(it, "data", Bitmap::class.java)
                }
                binding.ivImagen.setImageBitmap(imageBitmap)
            }
        }
}