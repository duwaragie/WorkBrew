package com.example.workbrew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signUpButton: Button = findViewById(R.id.signup_button)
        val loginButton: Button = findViewById(R.id.login_button)

        signUpButton.setOnClickListener {
            // Handle the sign-up process here (e.g., validate input, create user, etc.)

            // If sign-up is successful, navigate to HomepageActivity
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            // Optionally finish the current activity to prevent returning to the sign-up page
            finish()
        }

        loginButton.setOnClickListener {
            // Navigate to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
