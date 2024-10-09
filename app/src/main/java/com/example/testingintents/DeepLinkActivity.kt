package com.example.testingintents

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testingintents.databinding.ActivityDeepLinkBinding

class DeepLinkActivity : AppCompatActivity() {
    lateinit var binding : ActivityDeepLinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeepLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val uri = intent.data

        try{
            if(uri!=null){
                Log.e("success","got it bro ")
                binding.apply {
                    path.setText(uri.path)
                    query.setText(uri.query)
                }
            }

        }catch (e :Exception){
                Log.e("issue","got it bro ")

        }


    }
}