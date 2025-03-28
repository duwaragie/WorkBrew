package com.example.workbrew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.login_button)
        val signUpButton: Button = findViewById(R.id.signup_button)

        loginButton.setOnClickListener {
            // Handle the login process here (e.g., validate user credentials, etc.)

            // If login is successful, navigate to HomepageActivity
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            finish() // Optionally finish the current activity to prevent returning to the login page
        }

        signUpButton.setOnClickListener {
            // Navigate to SignUpActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
