package com.example.workbrew

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.workbrew.databinding.ActivityCoworkBinding
import com.google.android.material.button.MaterialButton

class CoworkingDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoworkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoworkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listeners for each card
        setupCardClickListeners()
    }

    private fun setupCardClickListeners() {
        // Card 1 - WORX
        binding.cardWorx.setOnClickListener {
            showCoworkingSpacePopup(
                R.drawable.coworkone,
                "WORX",
                "Modern coworking space with high-speed internet, meeting rooms, and a collaborative environment. \n\nAmenities:\n• High-speed WiFi\n• Meeting Rooms\n• Printer Access\n• Free Coffee\n• 24/7 Access"
            )
        }

        // Card 2 - HomeTree Coworking
        binding.cardHomeTree.setOnClickListener {
            showCoworkingSpacePopup(
                R.drawable.coworktwo,
                "HomeTree Coworking",
                "Comfortable and inspiring workspace designed for productivity and creativity. \n\nAmenities:\n• Ergonomic Workstations\n• Private Cabins\n• Event Space\n• Networking Opportunities\n• Complimentary Snacks"
            )
        }

        // Card 3 - Likuid Spaces
        binding.cardLikuidSpaces.setOnClickListener {
            showCoworkingSpacePopup(
                R.drawable.coworkthree,
                "Likuid Spaces",
                "Flexible workspace with innovative design and collaborative atmosphere. \n\nAmenities:\n• Hot Desking\n• Dedicated Desks\n• Conference Rooms\n• Kitchen Area\n• Podcast Room"
            )
        }

        // Card 4 - Hub9 Coworking
        binding.cardHub9.setOnClickListener {
            showCoworkingSpacePopup(
                R.drawable.coworkfour,
                "Hub9 Coworking",
                "Tech-friendly workspace with cutting-edge facilities and community-driven environment. \n\nAmenities:\n• Tech Zones\n• Training Rooms\n• Virtual Office\n• Community Events\n• 24/7 Security"
            )
        }
    }

    private fun showCoworkingSpacePopup(
        @DrawableRes imageResId: Int,
        spaceName: String,
        spaceDetails: String
    ) {
        val dialogView = layoutInflater.inflate(R.layout.coworking_space_card_layout, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        val imageView = dialogView.findViewById<ImageView>(R.id.popupSpaceImage)
        val nameTextView = dialogView.findViewById<TextView>(R.id.popupSpaceName)
        val detailsTextView = dialogView.findViewById<TextView>(R.id.popupSpaceDetails)
        val btnBookNow = dialogView.findViewById<MaterialButton>(R.id.btnBookNow)
        val btnClose = dialogView.findViewById<MaterialButton>(R.id.btnClose)

        imageView.setImageResource(imageResId)
        nameTextView.text = spaceName
        detailsTextView.text = spaceDetails

        btnBookNow.setOnClickListener {
            // Implement booking logic here
            Toast.makeText(this, "Booking for $spaceName", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        btnClose.setOnClickListener {
            dialog.dismiss()
        }
    }
}