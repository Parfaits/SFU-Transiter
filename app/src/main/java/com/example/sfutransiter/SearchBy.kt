package com.example.sfutransiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SearchBy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by)



        val busButton : Button =  this.findViewById(R.id.button4)
        busButton.setOnClickListener{
            val intent: Intent = Intent(this, SelectBus::class.java)
            startActivity(intent)
        }

        val busStopButton : Button =  this.findViewById(R.id.button)
        busStopButton.setOnClickListener{
            val intent: Intent = Intent(this, SelectStation::class.java)
            startActivity(intent)
        }
    }
}