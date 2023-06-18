package com.devexperto.modulo7_client_ej2.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.devexperto.modulo7_client_ej2.data.KtorClientService
import com.devexperto.modulo7_client_ej2.databinding.ActivityMainBinding
import com.devexperto.modulo7_client_ej2.ui.adapters.NotesAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NotesAdapter
    private lateinit var service: KtorClientService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = KtorClientService.create()

        setupUI()
    }

    private fun setupUI() {
        title = "Notas"
        setSupportActionBar(binding.toolbar)

        adapter = NotesAdapter() {
            val intent = Intent(this@MainActivity, NoteActivity::class.java)
            intent.putExtra("nota", it)
            startActivity(intent)
        }

        binding.rvData.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.rvData.adapter = adapter

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        getNotes()
    }

    fun getNotes() {
        lifecycleScope.launch {
            adapter.setNotas(service.getNotes())
        }
    }
}