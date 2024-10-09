package com.example.testingintents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast


// broadcast receiver to receive the aeroplane mode on off
class AirPlaneReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?){
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isTurnedOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) !=0
            if(isTurnedOn)
                Toast.makeText(context, "aeroplane mode  turned on ", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "aeroplane mode  is turned off ", Toast.LENGTH_SHORT).show();
        }
    }
}