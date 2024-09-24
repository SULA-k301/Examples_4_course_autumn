package com.zeek1910.exampleproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var signInButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        signInButton = findViewById(R.id.signInButton)
        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            signIn(email, password)
        }
        signInButton.setOnLongClickListener {
            emailEditText.text.clear()
            return@setOnLongClickListener true
        }

        findViewById<TextView>(R.id.title).setOnClickListener {
            showMessage("Title clicked")
        }

    }

    private fun signIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            showMessage("Please fill in all fields")
            return
        }
        if (!email.contains("@") && !email.contains(".")) {
            showMessage("Invalid email")
            return
        }
        if (email == EMAIL && password == PASSWORD) {
            showMessage("Sign in successful")
            AppSettings.getInstance(this).isUserLogin = true
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            showMessage("Sign in failed")
        }
    }

    private fun showMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private companion object {
        const val EMAIL = "test@test.com"
        const val PASSWORD = "123456"
    }
}