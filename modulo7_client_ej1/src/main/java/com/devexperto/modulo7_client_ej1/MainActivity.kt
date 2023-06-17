package com.devexperto.modulo7_client_ej1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.devexperto.modulo7_client_ej1.data.remote.KtorClientService
import com.devexperto.modulo7_client_ej1.databinding.ActivityMainBinding
import com.devexperto.modulo7_client_ej1.ui.activities.AddClienteActivity
import com.devexperto.modulo7_client_ej1.ui.activities.PedidosActivity
import com.devexperto.modulo7_client_ej1.ui.adapters.ListClientAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ListClientAdapter
    private lateinit var service: KtorClientService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = KtorClientService.create()

        setupUI()
    }

    override fun onResume() {
        super.onResume()
        getClientes()
    }

    fun getClientes() {
        lifecycleScope.launch {
            //val response = client.request("http://192.168.0.11:8080/cliente")
            //val result = response.body<MutableList<Cliente>>()
            //println(result)

            adapter.setClientes(service.getClientes())
        }
    }

    fun setupUI() {
        title = "Clientes"
        setSupportActionBar(binding.toolbar)

        adapter = ListClientAdapter(this@MainActivity) {
            val intent = Intent(this@MainActivity, AddClienteActivity::class.java)
            intent.putExtra("cliente", it)
            startActivity(intent)
        }
        binding.rvClientes.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvClientes.adapter = adapter

        binding.fabAddCliente.setOnClickListener {
            startActivity(Intent(this, AddClienteActivity::class.java))
        }

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuCarrito -> {
                    startActivity(Intent(this, PedidosActivity::class.java))
                    return@setOnMenuItemClickListener true
                }
                else -> {
                    Toast.makeText(this, "Opción no implementada", Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}