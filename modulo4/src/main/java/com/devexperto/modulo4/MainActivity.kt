package com.devexperto.modulo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo4.broadcastreceivers.BroadcastReceiversActivity
import com.devexperto.modulo4.databinding.ActivityMainBinding
import com.devexperto.modulo4.services.ServicesActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnServices.setOnClickListener {
            startActivity(Intent(this, ServicesActivity::class.java))
        }
        binding.btnReceivers.setOnClickListener {
            startActivity(Intent(this, BroadcastReceiversActivity::class.java))
        }
    }
}