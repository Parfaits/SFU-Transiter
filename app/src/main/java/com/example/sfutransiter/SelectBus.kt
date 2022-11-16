package com.example.sfutransiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectBus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_bus)


        val bus144Button : Button =  this.findViewById(R.id.btn144)
        bus144Button.setOnClickListener{
            val intent: Intent = Intent(this, BusSummary::class.java)
            intent.putExtra("key", bus144Button.text.toString())
            startActivity(intent)
        }

        val bus143Button : Button =  this.findViewById(R.id.btn143)
        bus143Button.setOnClickListener{
            val intent: Intent = Intent(this, BusSummary::class.java)
            intent.putExtra("key", bus143Button.text.toString())
            startActivity(intent)
        }

        val busR5Button : Button =  this.findViewById(R.id.btnR5)
        busR5Button.setOnClickListener{
            val intent: Intent = Intent(this, BusSummary::class.java)
            intent.putExtra("key", busR5Button.text.toString())
            startActivity(intent)
        }

        val bus145Button : Button =  this.findViewById(R.id.btn145)
        bus145Button.setOnClickListener{
            val intent: Intent = Intent(this, BusSummary::class.java)
            intent.putExtra("key", bus145Button.text.toString())
            startActivity(intent)
        }
    }
}