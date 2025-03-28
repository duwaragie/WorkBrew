package com.example.workbrew
import CafeAdapter
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workbrew.CafeData

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

        // Set up adapter
        cafeAdapter = CafeAdapter(cafeList)
        cafesRecyclerView.adapter = cafeAdapter

        // Set up hamburger menu click listener
        findViewById<ImageButton>(R.id.hamburgerMenu).setOnClickListener {
            // Implement menu open logic
        }
    }
}