package com.devexperto.modulo4.services.ejemplo1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BackgroundService : Service() {

    private lateinit var serviceScope: CoroutineScope

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        serviceScope = CoroutineScope(Dispatchers.Default)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        MyDataHolder.textLiveData.postValue("Servicio iniciado")
        serviceScope.launch {
            performBackgroundProcessing()
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        MyDataHolder.textLiveData.postValue("Servicio destruido")
        serviceScope.cancel()
    }

    private suspend fun performBackgroundProcessing() {
        for (i in 0 .. 5) {
            MyDataHolder.textLiveData.postValue("Cargando $i/5...")
            delay(1000)
        }
        stopSelf()
    }
}