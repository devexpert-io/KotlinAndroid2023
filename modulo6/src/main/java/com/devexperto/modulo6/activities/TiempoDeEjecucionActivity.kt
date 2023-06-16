package com.devexperto.modulo6.activities

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.devexperto.modulo6.databinding.ActivityTiempoDeEjecucionBinding

class TiempoDeEjecucionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeEjecucionBinding

    companion object {
        private const val CONTACTS_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeEjecucionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccederContactos.setOnClickListener {
            requestPermission(Manifest.permission.READ_CONTACTS, CONTACTS_PERMISSION_REQUEST_CODE)
        }
    }

    @Suppress("SameParameterValue")
    private fun requestPermission(permission: String, requestCode: Int) {
        if (isPermissionGranted(permission)) {
            showToast("El permiso ya ha sido otorgado")
            when(requestCode) {
                CONTACTS_PERMISSION_REQUEST_CODE -> { getContacts() }
            }
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CONTACTS_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showToast("Permiso de contactos otorgado")
                    getContacts()
                } else {
                    showToast("Permiso de contactos denegado")
                }
            }
        }
    }

    private fun getContacts() {
        showToast("Funcionalidad de contactos")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}