package com.devexperto.modulo7_client_ej1.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.modulo7_client_ej1.data.remote.dto.Cliente
import com.devexperto.modulo7_client_ej1.databinding.ItemClienteListBinding

class ListClientAdapter(context: Context, val itemClickListener: (Cliente) -> Unit) : RecyclerView.Adapter<ListClientAdapter.ViewHolder>() {
    private var clientes: List<Cliente> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemClienteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = clientes[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = clientes.size

    inner class ViewHolder(private val binding: ItemClienteListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cliente: Cliente) {
            binding.tvName.text = "${cliente.firstName} ${cliente.lastName}"
            binding.tvEmail.text = cliente.email

            binding.root.setOnClickListener{ itemClickListener(cliente) }
        }
    }

    fun setClientes(clientes: List<Cliente>) {
        this.clientes = clientes
        notifyDataSetChanged()
    }
}