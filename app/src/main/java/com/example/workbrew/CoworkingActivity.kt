package com.example.workbrew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CoworkingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cowork)

        // Initialize UI components
        val hamburgerMenu: ImageButton = findViewById(R.id.hamburgerMenu)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fabButton)
        val headerLogo: ImageView = findViewById(R.id.headerLogo)

        // Hamburger Menu Click Listener
//        hamburgerMenu.setOnClickListener {
//            // TODO: Implement menu drawer or popup menu functionality
//        }

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
//
//        // Header Logo Click Listener (Optional: can be used to refresh or go to home)
//        headerLogo.setOnClickListener {
//            // Optional: Refresh current page or navigate to main screen
//        }
    }

    // Optional: Add method to handle coworking space card clicks
   // private fun setupCoworkingSpaceCardListeners() {
        // Implement click listeners for each coworking space card
        // Example:
        // val worxCard: MaterialCardView = findViewById(R.id.worxCard)
        // worxCard.setOnClickListener {
        //     // Navigate to detailed view of WORX coworking space
        //     val intent = Intent(this, CoworkingDetailActivity::class.java)
        //     intent.putExtra("SPACE_NAME", "WORX")
        //     startActivity(intent)
        // }

}