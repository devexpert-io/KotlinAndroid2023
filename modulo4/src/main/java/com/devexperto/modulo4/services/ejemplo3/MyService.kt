package com.devexperto.modulo4.services.ejemplo3

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {
    private val mBinder: IBinder = LocalService()

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    inner class LocalService : Binder() {
        val service: MyService
            get() = this@MyService
    }

    val firstMessage: String
        get() = "Hola soy un primer mensaje"

    val secondMessage: String
        get() = "Soy un segundo mensaje"
}