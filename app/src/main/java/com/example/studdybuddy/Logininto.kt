package com.example.studdybuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Logininto : AppCompatActivity() {

    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logininto)

        auth= FirebaseAuth.getInstance()

        val emailbox = findViewById<EditText>(R.id.email)
        val passwordbox = findViewById<EditText>(R.id.editTextPassword)

        val btn1 = findViewById<Button>(R.id.buttonLogin)

        val btn2 = findViewById<TextView>(R.id.Registertext)

        btn1.setOnClickListener {
            login(emailbox,passwordbox)
        }

        btn2.setOnClickListener {
            GotoRegister()
        }
    }

    private fun GotoRegister() {
        val intent= Intent(this,Login::class.java)
        startActivity(intent)
    }

    private fun login(emailbox: EditText, passwordbox: EditText) {
        val email = emailbox.text.toString()
        val password = passwordbox.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
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