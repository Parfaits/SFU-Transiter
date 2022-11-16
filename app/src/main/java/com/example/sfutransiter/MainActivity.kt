package com.example.sfutransiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //For later use
        var username = findViewById<TextView>(R.id.editEmail).text
        var password = findViewById<TextView>(R.id.editPassword).text

        val anonButton : Button =  findViewById(R.id.btnAnonymous)
        anonButton.setOnClickListener{
            val intent: Intent = Intent(this, SearchBy::class.java)
            startActivity(intent)
        }
    }
}