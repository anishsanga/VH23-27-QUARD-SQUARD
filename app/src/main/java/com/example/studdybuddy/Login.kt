package com.example.studdybuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth= FirebaseAuth.getInstance()

        val btn1= findViewById<Button>(R.id.Regbtn)
        val btn2 = findViewById<TextView>(R.id.textViewLogin)
        val emailbox = findViewById<EditText>(R.id.email_edit_text)
        val passwordbox = findViewById<EditText>(R.id.editTextPassword)



        btn1.setOnClickListener {
            register(emailbox,passwordbox)
        }
        btn2.setOnClickListener {
            Riderect()
        }




        val currentUser = auth.currentUser
        if (currentUser != null) {

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }




    }

    private fun Riderect() {
        val intent= Intent(this,Logininto::class.java)
        startActivity(intent)
    }

    private fun register(emailbox: EditText, passwordbox: EditText) {
        val email = emailbox.text.toString()
        val password = passwordbox.text.toString()

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                progressBar.visibility = View.GONE

                if (task.isSuccessful) {
                    val intent = Intent(this, Dashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(applicationContext, "Registration failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }


}