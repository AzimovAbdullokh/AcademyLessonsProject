package com.example.academylessons.presentation.onboarding_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.academylessons.R
import com.example.academylessons.databinding.FragmentOnBoardingScreenBinding
import com.example.academylessons.data.preferences.UserEnteredSharedPref


class OnBoardingScreenFragment : Fragment() {

    private val binding: FragmentOnBoardingScreenBinding by lazy {
        FragmentOnBoardingScreenBinding.inflate(layoutInflater)
    }

    private val sharedPreferences: UserEnteredSharedPref by lazy {
        UserEnteredSharedPref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (sharedPreferences.getIsUserFirstSign()) {
            binding.getStartedBtn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_onBoardingScreenFragment_to_mainScreenFragment
                )
            }
        } else {
            binding.getStartedBtn.setOnClickListener {
                sharedPreferences.setUserFirstSign(true)
                findNavController().navigate(
                    R.id.action_onBoardingScreenFragment_to_mainScreenFragment
                )
            }
        }
    }
}