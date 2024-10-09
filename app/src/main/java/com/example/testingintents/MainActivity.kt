package com.example.testingintents

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testingintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding :ActivityMainBinding
    private  val airPlaneReceiver = AirPlaneReceiver() // dynamic brodcast receiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(airPlaneReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // what is bundle
        // adb
        // launch mode -> single top

        /**
         * Explicit intent for opening app inside my app
         * **/
        binding.seond.setOnClickListener{
            Intent(this,DeepLinkActivity::class.java).also {
                startActivity(it)
            }
        }
        /**
         * Explicit intent for opening other app
         * **/
        binding.youtuebe.setOnClickListener {
            Intent(Intent.ACTION_MAIN).also {
                it.`package` = "com.google.android.youtube"
                startActivity(it)
            }
        }

        binding.implicit.setOnClickListener {
            Intent(Intent.ACTION_SEND).also {
                it.type = "text/plain"
                it.putExtra(Intent.EXTRA_EMAIL, arrayOf("vkb@google.com"))
                it.putExtra(Intent.EXTRA_SUBJECT,"this is implicit intent ")
                it.putExtra(Intent.EXTRA_TEXT,"this is to open the email app , he cool bro")
                if(it.resolveActivity(packageManager) !=null){
                    startActivity(it)
                }
            }
        }



    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airPlaneReceiver)
    }
}