package com.devexperto.modulo7_client_ej1.ui.activities

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.devexperto.modulo7_client_ej1.R
import com.devexperto.modulo7_client_ej1.databinding.ActivityAddClienteBinding
import java.io.Serializable

class AddClienteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddClienteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
        setupUI()

        binding.btnGuardar.setOnClickListener {

        }
        binding.btnCancelar.setOnClickListener { finish() }

    }

    private fun setupData() {

    }

    private fun setupUI() {

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuEliminar -> {
                    eliminarCliente()
                    return@setOnMenuItemClickListener true
                }
                else -> {
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }

    private fun <T : Serializable?> getSerializable(activity: Activity, name: String, clazz: Class<T>): T? {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            activity.intent.getSerializableExtra(name, clazz)
        else
            activity.intent.getSerializableExtra(name) as T
    }

    private fun eliminarCliente() {

    }

    private fun actualizarCliente() {

    }

    private fun agregarCliente() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        return true
    }
}