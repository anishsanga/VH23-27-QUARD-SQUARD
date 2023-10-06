package com.example.studdybuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btn = findViewById<Button>(R.id.button3)

        btn.setOnClickListener {
            val intent= Intent(this,Createroom::class.java)
            startActivity(intent)
        }
    }


}

