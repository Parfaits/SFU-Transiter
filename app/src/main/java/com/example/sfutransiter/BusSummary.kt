package com.example.sfutransiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BusSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_summary)

        val busText : TextView =  this.findViewById(R.id.txtBusTitle)
        busText.text = intent.getStringExtra("key")

        val commentButton : Button =  this.findViewById(R.id.txtComments)
        commentButton.setOnClickListener{
            val intent: Intent = Intent(this, CommentBoard::class.java)
            intent.putExtra("key", busText.text.toString())
            startActivity(intent)
        }
    }
}