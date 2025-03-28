package com.example.workbrew

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddPlaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addplace)

        val toggleCafe: ToggleButton = findViewById(R.id.toggleCafe)
        val toggleCowork: ToggleButton = findViewById(R.id.toggleCowork)

        // Listener for Cafe toggle
        toggleCafe.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                toggleCafe.setTextColor(Color.WHITE)
                toggleCowork.isChecked = false
                toggleCowork.setTextColor(Color.BLACK)
            } else {
                toggleCafe.setTextColor(Color.BLACK)
            }
        }

        // Listener for Coworking toggle
        toggleCowork.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                toggleCowork.setTextColor(Color.WHITE)
                toggleCafe.isChecked = false
                toggleCafe.setTextColor(Color.BLACK)
            } else {
                toggleCowork.setTextColor(Color.BLACK)
            }
        }

        // Setup Spinner
        val priceSpinner: Spinner = findViewById(R.id.spinner)

        // Create price range options
        val priceRanges = arrayOf(
            "Select Price Range",
            "Low",
            "Medium",
            "High",
        )

        // Create an ArrayAdapter using a simple spinner layout and the price ranges array
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            priceRanges
        )

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        priceSpinner.adapter = adapter

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fabButton)

        // Handle Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomepageActivity::class.java))
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