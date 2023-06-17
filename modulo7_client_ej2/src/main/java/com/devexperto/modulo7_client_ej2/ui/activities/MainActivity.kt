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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupUI()
    }

    private fun setupUI() {
        title = "Notas"
        setSupportActionBar(binding.toolbar)

        adapter = NotesAdapter() {


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


        }
    }
}