package com.devexperto.modulo6.activities

import android.content.Context
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.devexperto.modulo6.databinding.ActivityTiempoDeInstalacionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


class TiempoDeInstalacionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeInstalacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeInstalacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEstadoDeRed.setOnClickListener {
            binding.tvEstadoDeRed.text =
                if (obtenerDisponibilidadDeLaRed(this)) "Conectado" else "Desconectado"
        }
        binding.btnVibracion.setOnClickListener {
            vibrar()
        }
        binding.btnAccederAInternet.setOnClickListener {
            descargarImagen()
        }
    }

    private fun obtenerDisponibilidadDeLaRed(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val conn = connectivityManager.activeNetwork ?: return false
        val activeNewtwork = connectivityManager.getNetworkCapabilities(conn) ?: return false
        return when {
            activeNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            activeNewtwork.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    @Suppress("DEPRECATION")
    private fun vibrar() {
        val vibrator = ContextCompat.getSystemService(this, Vibrator::class.java) as Vibrator
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        1000,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(1000)
            }
        }
    }

    private fun descargarImagen() {
        val imageUrl = "https://definicion.de/wp-content/uploads/2015/10/android.png"
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val bitmap = withContext(Dispatchers.IO) {
                    URL(imageUrl).openStream().use { stream ->
                        BitmapFactory.decodeStream(stream)
                    }
                }
                bitmap?.let { binding.ivImagen.setImageBitmap(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}