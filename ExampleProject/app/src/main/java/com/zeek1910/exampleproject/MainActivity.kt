package com.zeek1910.exampleproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.zeek1910.exampleproject.fragments.ChatFragment
import com.zeek1910.exampleproject.fragments.HomeFragment
import com.zeek1910.exampleproject.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val homeFragment = HomeFragment()
    private val chatFragment = ChatFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, homeFragment)
                        .commit()
                    true
                }

                R.id.chats -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, chatFragment)
                        .commit()
                    true
                }

                R.id.profile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, profileFragment)
                        .commit()
                    true
                }

                else -> false
            }
        }


//        logoutButton = findViewById(R.id.buttonLogout)
//        logoutButton.setOnClickListener {
//            AppSettings.getInstance(this).isUserLogin = false
//            startActivity(Intent(this, SignInActivity::class.java))
//            finish()
//        }
    }
}