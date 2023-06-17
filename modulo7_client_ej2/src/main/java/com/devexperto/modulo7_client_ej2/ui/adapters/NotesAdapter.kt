package com.devexperto.modulo7_client_ej2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devexperto.modulo7_client_ej2.data.dto.Note
import com.devexperto.modulo7_client_ej2.databinding.ItemNoteBinding

class NotesAdapter(val itemClickListener: (Note) -> Unit) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    private var notas: List<Note> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = notas[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = notas.size

    inner class ViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notes: Note) {
            binding.tvTitulo.text = notes.title
            binding.tvDescripcion.text = notes.description
            binding.tvTipo.text = notes.type

            binding.root.setOnClickListener{ itemClickListener(notes) }
        }
    }

    fun setNotas(notes: List<Note>) {
        this.notas = notes
        notifyDataSetChanged()
    }
}