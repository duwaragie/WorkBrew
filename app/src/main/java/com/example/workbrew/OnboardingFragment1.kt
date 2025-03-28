package com.example.workbrew

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import androidx.fragment.app.Fragment
import com.example.workbrew.databinding.FragmentOnboarding1Binding

class OnboardingFragment1 : Fragment() {

    private lateinit var binding: FragmentOnboarding1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboarding1Binding.inflate(inflater, container, false)

        // Skip Button: Navigate to WelcomeActivity
        binding.skipButton1.setOnClickListener {
            startActivity(Intent(requireContext(), WelcomeActivity::class.java))
            requireActivity().finish()
        }

        // Next Button: Move to the second screen
        binding.nextButton1.setOnClickListener {
            val viewPager = (requireActivity() as OnboardingActivity).findViewById<ViewPager2>(R.id.onboarding_view_pager)
            viewPager.currentItem = 1 // Move to the second screen (index 1)
        }

        return binding.root
    }
}