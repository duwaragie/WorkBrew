package com.example.workbrew

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.widget.ImageView // Import ImageView

class SplashActivity : AppCompatActivity() {
    private lateinit var splashLogo: ImageView // Declare ImageView variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize splashLogo using findViewById
        splashLogo = findViewById(R.id.splash_logo)

        // Load GIF with Glide
        Glide.with(this).asGif().load(R.drawable.workbrew_logo_gif).into(splashLogo)

        // Move to Onboarding after delay
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3 seconds delay
    }
}
