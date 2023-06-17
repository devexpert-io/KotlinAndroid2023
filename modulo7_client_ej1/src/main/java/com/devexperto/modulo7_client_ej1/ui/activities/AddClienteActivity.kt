package com.devexperto.modulo7_client_ej1.ui.activities

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.devexperto.modulo7_client_ej1.R
import com.devexperto.modulo7_client_ej1.data.remote.KtorClientService
import com.devexperto.modulo7_client_ej1.data.remote.dto.Cliente
import com.devexperto.modulo7_client_ej1.databinding.ActivityAddClienteBinding
import kotlinx.coroutines.launch
import java.io.Serializable

class AddClienteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddClienteBinding
    lateinit var service: KtorClientService
    var cliente: Cliente? = null
    var isNewClient = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
        setupUI()

        binding.btnGuardar.setOnClickListener {
            if (isNewClient) agregarCliente() else actualizarCliente()
        }
        binding.btnCancelar.setOnClickListener { finish() }

    }

    private fun setupData() {
        service = KtorClientService.create()
        cliente = getSerializable(this, "cliente", Cliente::class.java)

        if (cliente != null) {
            isNewClient = false
            binding.etNombre.setText(cliente?.firstName)
            binding.etApellido.setText(cliente?.lastName)
            binding.etCorreo.setText(cliente?.email)
        } else {
            isNewClient = true
        }
    }

    private fun setupUI() {
        title = if (isNewClient) "Agregar cliente" else "Detalle cliente"
        setSupportActionBar(binding.toolbar)
        binding.btnGuardar.text = if (isNewClient) "Agregar" else "Actualizar"
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
        lifecycleScope.launch {
            val respose = cliente?.let { service.deleteCliente(it.id.toInt()) }
            Toast.makeText(this@AddClienteActivity, respose?.message ?: ":", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun actualizarCliente() {
        cliente?.firstName = binding.etNombre.text.toString()
        cliente?.lastName = binding.etApellido.text.toString()
        cliente?.email = binding.etCorreo.text.toString()

        lifecycleScope.launch {
            val respose = cliente?.let { service.updateCliente(it) }
            Toast.makeText(this@AddClienteActivity, respose?.message ?: "", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun agregarCliente() {
        val cli = Cliente(
            System.currentTimeMillis().toString(),
            binding.etNombre.text.toString(),
            binding.etApellido.text.toString(),
            binding.etCorreo.text.toString(),
        )
        lifecycleScope.launch {
            val respose = service.addCliente(cli)
            Toast.makeText(this@AddClienteActivity, respose.message, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if(!isNewClient) menuInflater.inflate(R.menu.menu_eliminar, menu)
        return true
    }
}