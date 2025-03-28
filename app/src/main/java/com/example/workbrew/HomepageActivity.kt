package com.example.workbrew

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workbrew.databinding.ActivityHomepageBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fabButton)

        // Handle Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Stay on homepage or reload home fragment
                    true
                }
                R.id.nav_cafes -> {
                    startActivity(Intent(this, CafesActivity::class.java))
                    true
                }
                R.id.nav_coworking -> {
                    startActivity(Intent(this, CoworkingActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Handle Floating Action Button Click (Navigating to Add Place)
        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddPlaceActivity::class.java))
        }
    }
}
