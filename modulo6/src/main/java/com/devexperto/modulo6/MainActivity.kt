package com.devexperto.modulo6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devexperto.modulo6.activities.SinPermisosActivity
import com.devexperto.modulo6.activities.TiempoDeEjecucionActivity
import com.devexperto.modulo6.activities.TiempoDeInstalacionActivity
import com.devexperto.modulo6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSinPermisos.setOnClickListener{
            startActivity(Intent(this, SinPermisosActivity::class.java))
        }
        binding.btnTiempoDeInstalacion.setOnClickListener{
            startActivity(Intent(this, TiempoDeInstalacionActivity::class.java))
        }
        binding.btnTiempoDeEjecucion.setOnClickListener{
            startActivity(Intent(this, TiempoDeEjecucionActivity::class.java))
        }
    }
}