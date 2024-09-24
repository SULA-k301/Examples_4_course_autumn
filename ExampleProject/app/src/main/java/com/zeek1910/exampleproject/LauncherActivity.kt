package com.zeek1910.exampleproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_launcher)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val pref = AppSettings.getInstance(this)
        if (pref.isUserLogin) {
            Log.d("LauncherActivity", "User is already logged in")
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Log.d("LauncherActivity", "User is not logged in")
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}