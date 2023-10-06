package com.example.studdybuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton
import com.google.firebase.database.FirebaseDatabase

class Createroom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createroom)

        val createRoomButton = findViewById<MaterialButton>(R.id.Creategroup)

        createRoomButton.setOnClickListener {
            val roomName = "This is test doing "
            val subjectName = "Marathi"
            val roomNumber = "VCET004"

            // Create a room and save to Firebase
            createRoom(roomName, subjectName, roomNumber)
        }
    }

    private fun createRoom(roomName: String, subjectName: String, roomNumber: String) {

        val room = Room(roomName, subjectName, roomNumber)

        val database = FirebaseDatabase.getInstance().reference.child("rooms").push()
        database.setValue(room)


        val intent = Intent(this, Roombuddy::class.java)
        intent.putExtra("roomId", database.key)
        startActivity(intent)
    }
}