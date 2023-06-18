package com.devexperto.modulo7_client_ej2.ui.activities

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.devexperto.modulo7_client_ej2.R
import com.devexperto.modulo7_client_ej2.data.KtorClientService
import com.devexperto.modulo7_client_ej2.data.dto.Note
import com.devexperto.modulo7_client_ej2.databinding.ActivityNoteBinding
import kotlinx.coroutines.launch
import java.io.Serializable

class NoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoteBinding
    lateinit var service: KtorClientService
    var nota: Note? = null
    var isNewClient = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
        setupUI()

        binding.btnGuardar.setOnClickListener {
            if (isNewClient) agregarNota() else actualizarNota()
        }
        binding.btnCancelar.setOnClickListener { finish() }
    }

    private fun setupData() {
        service = KtorClientService.create()
        nota = getSerializable(this, "nota", Note::class.java)

        if (nota != null) {
            isNewClient = false
            binding.etTitulo.setText(nota?.title)
            binding.etDescripcion.setText(nota?.description)
            binding.etTipo.setText(nota?.type)
        } else {
            isNewClient = true
        }
    }

    private fun setupUI() {
        title = if (isNewClient) "Agregar Nota" else "Detalle Nota"
        setSupportActionBar(binding.toolbar)
        binding.btnGuardar.text = if (isNewClient) "Agregar" else "Actualizar"
        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_delete -> {
                    eliminarNota()
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

    private fun eliminarNota() {
        lifecycleScope.launch {
            nota?.let { service.deleteNote(it) }
            Toast.makeText(this@NoteActivity, "Eliminado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun actualizarNota() {
        nota?.title = binding.etTitulo.text.toString()
        nota?.description = binding.etDescripcion.text.toString()
        nota?.type = binding.etTipo.text.toString()

        lifecycleScope.launch {
            nota?.let { service.updateNote(it) }
            Toast.makeText(this@NoteActivity, "Actualizado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun agregarNota() {
        val not = Note(
            System.currentTimeMillis(),
            binding.etTitulo.text.toString(),
            binding.etDescripcion.text.toString(),
            binding.etTipo.text.toString(),
        )
        lifecycleScope.launch {
            service.addNote(not)
            Toast.makeText(this@NoteActivity, "Agregado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if(!isNewClient) menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}