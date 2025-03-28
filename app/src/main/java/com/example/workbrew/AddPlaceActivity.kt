package com.example.workbrew

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

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



    }
}