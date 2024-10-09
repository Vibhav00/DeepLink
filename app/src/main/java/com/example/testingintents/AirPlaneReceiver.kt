package com.example.testingintents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class AirPlaneReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?){
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isTurnedOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) !=0
            if(isTurnedOn)
                Toast.makeText(context, "wifi turned on ", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "wifi is turned off ", Toast.LENGTH_SHORT).show();
        }
    }
}