package com.devexperto.modulo7_client_ej1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.devexperto.modulo7_client_ej1.data.remote.KtorClientService
import com.devexperto.modulo7_client_ej1.databinding.ActivityPedidosBinding
import com.devexperto.modulo7_client_ej1.ui.adapters.ListPedidosAdapter
import kotlinx.coroutines.launch

class PedidosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidosBinding
    private lateinit var adapter: ListPedidosAdapter
    private lateinit var service: KtorClientService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = KtorClientService.create()

        setupUI()

        getClientes()
    }

    fun getClientes() {
        lifecycleScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            val response = service.getPedidos()
            adapter = ListPedidosAdapter(response)
            binding.rvPedidos.layoutManager = LinearLayoutManager(this@PedidosActivity)
            binding.rvPedidos.adapter = adapter
            binding.progressBar.visibility = View.GONE
        }
    }

    fun setupUI() {
        title = "Pedidos"
        setSupportActionBar(binding.toolbar)
    }
}