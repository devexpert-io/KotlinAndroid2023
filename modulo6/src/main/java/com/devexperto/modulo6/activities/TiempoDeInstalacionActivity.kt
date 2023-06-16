package com.devexperto.modulo6.activities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo6.databinding.ActivityTiempoDeInstalacionBinding

class TiempoDeInstalacionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeInstalacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeInstalacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEstadoDeRed.setOnClickListener {
            binding.tvEstadoDeRed.text = if (obtenerDisponibilidadDeLaRed(this)) "Conectado" else "Desconectado"
        }
        binding.btnVibracion.setOnClickListener {

        }
        binding.btnAccederAInternet.setOnClickListener {

        }
    }

    private fun obtenerDisponibilidadDeLaRed(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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
}