package com.devexperto.modulo4_emisor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo4_emisor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            sendCustomBroadcast(binding.etTexto.text.toString())
        }
    }

    private fun sendCustomBroadcast(text: String) {
        val intent = Intent("com.devexperto.modulo4.MY_ACTION")
        intent.putExtra("message", text)
        sendBroadcast(intent)
    }
}