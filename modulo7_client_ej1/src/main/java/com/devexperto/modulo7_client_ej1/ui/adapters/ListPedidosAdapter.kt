package com.devexperto.modulo7_client_ej1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.modulo7_client_ej1.data.remote.dto.Pedido
import com.devexperto.modulo7_client_ej1.databinding.ItemPedidoListBinding

class ListPedidosAdapter(private val items: MutableList<Pedido>) : RecyclerView.Adapter<ListPedidosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPedidoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemPedidoListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pedido: Pedido) {
            binding.tvCodigoProducto.text = pedido.number
            var result = ""
            pedido.contents.forEach {
                result += "· ${it.item}  |  Cant: ${it.amount}  |  Bs. ${it.price}\n"
            }
            binding.tvProductos.text = result.trim()
        }
    }
}