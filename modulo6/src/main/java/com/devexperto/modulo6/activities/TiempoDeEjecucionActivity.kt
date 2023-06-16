package com.devexperto.modulo6.activities

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.devexperto.modulo6.databinding.ActivityTiempoDeEjecucionBinding

class TiempoDeEjecucionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeEjecucionBinding

    companion object {
        private const val CONTACTS_PERMISSION_REQUEST_CODE = 1
        private const val LOCATION_PERMISSION_REQUEST_CODE = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeEjecucionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccederContactos.setOnClickListener {
            requestPermission(Manifest.permission.READ_CONTACTS, CONTACTS_PERMISSION_REQUEST_CODE)
        }
        binding.btnAccederUbicacion.setOnClickListener {
            requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    private fun requestPermission(permission: String, requestCode: Int) {
        if (isPermissionGranted(permission)) {
            showToast("El permiso ya ha sido otorgado")
            when(requestCode) {
                CONTACTS_PERMISSION_REQUEST_CODE -> { getContacts() }
                LOCATION_PERMISSION_REQUEST_CODE -> { getLocalization() }
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
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showToast("Permiso de localización otorgado")
                    getLocalization()
                } else {
                    showToast("Permiso de localización denegado")
                }
            }
        }
    }

    private fun getContacts() {
        showToast("Funcionalidad de contactos")
    }

    private fun getLocalization() {
        showToast("Funcionalidad de localización")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}