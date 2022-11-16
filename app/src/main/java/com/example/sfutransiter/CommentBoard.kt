package com.example.sfutransiter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CommentBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_board)


        val busTitleText : TextView =  this.findViewById(R.id.txtBusTitle3)
        busTitleText.text = intent.getStringExtra("key")
    }
}