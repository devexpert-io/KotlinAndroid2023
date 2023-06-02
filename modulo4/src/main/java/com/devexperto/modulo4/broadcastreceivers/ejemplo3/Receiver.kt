package com.devexperto.modulo4.broadcastreceivers.ejemplo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("message")
        MyDataHolder.textLiveData.postValue(message)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}