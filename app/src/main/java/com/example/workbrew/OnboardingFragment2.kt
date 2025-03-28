package com.example.workbrew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import androidx.fragment.app.Fragment
import com.example.workbrew.databinding.FragmentOnboarding2Binding

class OnboardingFragment2 : Fragment() {

    private lateinit var binding: FragmentOnboarding2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboarding2Binding.inflate(inflater, container, false)

        // Previous Button: Move to the first screen
        binding.previousButton2.setOnClickListener {
            val viewPager = (requireActivity() as OnboardingActivity).findViewById<ViewPager2>(R.id.onboarding_view_pager)
            viewPager.currentItem = 0 // Move to the first screen (index 0)
        }

        // Next Button: Move to the third screen
        binding.nextButton2.setOnClickListener {
            val viewPager = (requireActivity() as OnboardingActivity).findViewById<ViewPager2>(R.id.onboarding_view_pager)
            viewPager.currentItem = 2 // Move to the third screen (index 2)
        }

        return binding.root
    }
}