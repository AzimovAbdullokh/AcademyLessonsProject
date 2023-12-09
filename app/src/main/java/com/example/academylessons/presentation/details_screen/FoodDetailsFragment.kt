package com.example.academylessons.presentation.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.academylessons.data.models.FoodModel
import com.example.academylessons.data.preferences.FoodCartSharedPref
import com.example.academylessons.databinding.FragmentFoodDetailsBinding
import com.example.academylessons.presentation.main_screen.MainScreenFragment.Companion.FOOD_KEY
import com.google.android.material.snackbar.Snackbar

class FoodDetailsFragment : Fragment() {

    private val binding by lazy {
        FragmentFoodDetailsBinding.inflate(layoutInflater)
    }

    private val sharedPreferences: FoodCartSharedPref by lazy {
        FoodCartSharedPref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnBackPressedDispatcher()
        val foodModel = arguments?.getSerializable(FOOD_KEY) as? FoodModel
        foodModel?.let {
            setupViews(it)
            setupClickListeners(foodModel)
        }
    }

    private fun setupClickListeners(foodModel: FoodModel) {
        binding.addToCartBtn.setOnClickListener {
            sharedPreferences.saveFood(foodModel)
            Snackbar.make(
                requireView(),
                "Added to cart successfully",
                Snackbar.LENGTH_SHORT
            ).show()
            findNavController().popBackStack()
        }
    }

    private fun setupOnBackPressedDispatcher() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
    }

    private fun setupViews(foodModel: FoodModel) {
        binding.apply {
            Glide.with(requireContext())
                .load(foodModel.foodImage)
                .into(ivFood)
            tvFoodTitle.text = foodModel.foodName
            tvFoodDescription.text = foodModel.foodDescription
            tvFoodPrice.text = "${foodModel.foodPrice}$"
        }
    }
}