package com.example.academylessons.presentation.cart_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.academylessons.data.models.FoodModel
import com.example.academylessons.data.preferences.FoodCartSharedPref
import com.example.academylessons.databinding.FragmentFoodCartScreenBinding
import com.example.academylessons.presentation.adapter.FoodsAdapter
import com.example.academylessons.presentation.adapter.FoodsItemClickListener

class FoodCartScreenFragment : Fragment(), FoodsItemClickListener {

    private val binding: FragmentFoodCartScreenBinding by lazy {
        FragmentFoodCartScreenBinding.inflate(layoutInflater)
    }

    private val sharedPreferences: FoodCartSharedPref by lazy {
        FoodCartSharedPref(requireContext())
    }

    private val adapter: FoodsAdapter by lazy {
        FoodsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        val savedFoodList = sharedPreferences.getAllSavedFoods()
        adapter.updateList(savedFoodList)
        binding.savedFoodRv.adapter = adapter
    }

    override fun onFoodItemClick(foodModel: FoodModel) {

    }
}