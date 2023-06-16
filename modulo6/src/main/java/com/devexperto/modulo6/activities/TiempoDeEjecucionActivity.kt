package com.devexperto.modulo6.activities

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.devexperto.modulo6.databinding.ActivityTiempoDeEjecucionBinding

class TiempoDeEjecucionActivity : AppCompatActivity() {
    lateinit var binding: ActivityTiempoDeEjecucionBinding

    companion object {
        private const val CONTACTS_PERMISSION_REQUEST_CODE = 1
        private const val LOCATION_PERMISSION_REQUEST_CODE = 2
        private const val CAMERA_PERMISSION_REQUEST_CODE = 3
        private const val MULTIPLE_PERMISSION_REQUEST_CODE = 4

        var requiredPermissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiempoDeEjecucionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccederContactos.setOnClickListener {
            requestPermission(Manifest.permission.READ_CONTACTS, CONTACTS_PERMISSION_REQUEST_CODE)
        }
        binding.btnAccederUbicacion.setOnClickListener {
            requestPermission(
                Manifest.permission.ACCESS_FINE_LOCATION,
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
        binding.btnAccederCamara.setOnClickListener {
            requestPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_REQUEST_CODE)
        }
        binding.btnAccederMultiplesPermisos.setOnClickListener {
            requestPermissions()
        }
    }

    private fun requestPermission(permission: String, requestCode: Int) {
        if (isPermissionGranted(permission)) {
            showToast("El permiso ya ha sido otorgado")
            when (requestCode) {
                CONTACTS_PERMISSION_REQUEST_CODE -> {
                    getContacts()
                }

                LOCATION_PERMISSION_REQUEST_CODE -> {
                    getLocalization()
                }

                CAMERA_PERMISSION_REQUEST_CODE -> {
                    openCamera()
                }
            }
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }
    }

    private fun requestPermissions() {
        val permissionsToRequest = mutableListOf<String>()
        for (permission in requiredPermissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                permissionsToRequest.add(permission)
            }
        }
        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                MULTIPLE_PERMISSION_REQUEST_CODE
            )
        } else {
            showToast("Los permisos ya ha sido otorgados")
            getFuncionalidadMultiplesPermisos()
        }
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
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

            CAMERA_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showToast("Permiso de camara otorgado")
                    openCamera()
                } else {
                    showToast("Permiso de camara denegado")
                }
            }

            MULTIPLE_PERMISSION_REQUEST_CODE -> {
                var allPermissionsGranted = true
                for (result in grantResults) {
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        allPermissionsGranted = false
                        break
                    }
                }
                if (allPermissionsGranted) {
                    showToast("Todos los permisos fueron otorgados")
                    getFuncionalidadMultiplesPermisos()
                } else {
                    showPermissionDialog()
                }
            }
        }
    }

    private fun openCamera() {
        showToast("Funcionalidad de cámara")
    }

    private fun getContacts() {
        showToast("Funcionalidad de contactos")
    }

    private fun getLocalization() {
        showToast("Funcionalidad de localización")
    }

    private fun getFuncionalidadMultiplesPermisos() {
        showToast("Funcionalidad Multiples permisos")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showPermissionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Se requiere permisos")
            .setMessage("Se necesitan algunos permisos para poder usar esta aplicación sin ningún problema.")
            .setPositiveButton("Otorgar") { dialog, _ ->
                dialog.cancel()
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                val uri = Uri.fromParts("package", this.packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}