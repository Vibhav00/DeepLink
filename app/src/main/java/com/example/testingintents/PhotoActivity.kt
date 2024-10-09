package com.example.testingintents

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }


        /**
         * taking the extras that came , for the image link
         * **/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val uri =  intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
            Toast.makeText(this, "the uri is = $uri", Toast.LENGTH_SHORT).show();
        } else {
            TODO("VERSION.SDK_INT < TIRAMISU")
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)


        /**
         * if the activity is single top
         * **/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val uri =  intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
            Toast.makeText(this, "the uri is = $uri", Toast.LENGTH_SHORT).show();
        } else {
            TODO("VERSION.SDK_INT < TIRAMISU")
        }


    }
}