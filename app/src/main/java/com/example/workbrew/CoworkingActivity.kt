package com.example.workbrew

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
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

        // Card Views
        val cardWorx: CardView = findViewById(R.id.cardWorx)
        val cardHomeTree: CardView = findViewById(R.id.cardHomeTree)
        val cardLikuidSpaces: CardView = findViewById(R.id.cardLikuidSpaces)
        val cardHub9: CardView = findViewById(R.id.cardHub9)

        // Setup card click listeners
        setupCardClickListener(
            cardWorx, "WORX", R.drawable.coworkone,
            "Worx is one of the most aesthetically pleasing coworking spaces. " +
                    "It has a beautiful, green zen garden, a rooftop terrace, outdoor cabanas, and a swimming pool."
        )

        setupCardClickListener(
            cardHomeTree, "HomeTree Coworking", R.drawable.coworktwo,
            "HomeTree Coworking offers a serene and collaborative environment. " +
                    "With modern amenities and a focus on sustainability, it provides an ideal workspace."
        )

        setupCardClickListener(
            cardLikuidSpaces, "Likuid Spaces", R.drawable.coworkthree,
            "Likuid Spaces provides a dynamic and flexible workspace. " +
                    "Designed for entrepreneurs and remote workers, it offers state-of-the-art facilities."
        )

        setupCardClickListener(
            cardHub9, "Hub9 Coworking", R.drawable.coworkfour,
            "Hub9 Coworking is a premium workspace solution with innovative design. " +
                    "Offering networking opportunities and cutting-edge technology."
        )

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


    }private fun setupCardClickListener(
        cardView: CardView,
        spaceName: String,
        imageResourceId: Int,
        spaceDescription: String
    ) {
        cardView.setOnClickListener {
            val dialog = Dialog(this, android.R.style.Theme_Translucent_NoTitleBar)
            dialog.setContentView(R.layout.coworking_space_card_layout)

            // Find popup views
            val popupSpaceImage: ImageView = dialog.findViewById(R.id.popupSpaceImage)
            val popupSpaceName: TextView = dialog.findViewById(R.id.popupSpaceName)
            val popupSpaceDetails: TextView = dialog.findViewById(R.id.popupSpaceDetails)
            val btnBookNow: MaterialButton = dialog.findViewById(R.id.btnBookNow)
            val btnClose: MaterialButton = dialog.findViewById(R.id.btnClose)

            // Set popup content
            popupSpaceImage.setImageResource(imageResourceId)
            popupSpaceName.text = spaceName
            popupSpaceDetails.text = spaceDescription

            // Book Now button
            btnBookNow.setOnClickListener {
                // TODO: Implement booking logic
                // For now, just dismiss the dialog
                dialog.dismiss()
            }

            // Close button
            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

    }
}