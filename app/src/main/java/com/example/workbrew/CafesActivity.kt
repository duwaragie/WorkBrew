package com.example.workbrew
import CafeAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workbrew.CafeData
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CafesActivity : AppCompatActivity() {
    private lateinit var cafesRecyclerView: RecyclerView
    private lateinit var cafeAdapter: CafeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe)

        // Initialize RecyclerView
        cafesRecyclerView = findViewById(R.id.cafesRecyclerView)
        cafesRecyclerView.layoutManager = LinearLayoutManager(this)



        // Create list of cafes
        val cafeList = listOf(
            CafeData("Java Lounge", "📍 Bambalapitiya","⭐4.9", R.drawable.cafeone),
            CafeData("Commons", "📍Flower Road","⭐4.6", R.drawable.cafetwo),
            CafeData("Tea Avenue", "📍Dulication Road","⭐4.5", R.drawable.cafethree),
            CafeData("Peppermint Cafe", "📍Wellawatte","⭐4.8", R.drawable.cafefour)
        )


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

        // Set up adapter
        cafeAdapter = CafeAdapter(cafeList)
        cafesRecyclerView.adapter = cafeAdapter

        // Set up hamburger menu click listener
        findViewById<ImageButton>(R.id.hamburgerMenu).setOnClickListener {
            // Implement menu open logic
        }




    }
}