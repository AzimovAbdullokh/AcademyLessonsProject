package com.example.academylessons.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.academylessons.R
import com.example.academylessons.data.models.FoodModel
import com.example.academylessons.databinding.FragmentMainScreenBinding
import com.example.academylessons.presentation.adapter.FoodsAdapter
import com.example.academylessons.presentation.adapter.FoodsItemClickListener


class MainScreenFragment : Fragment(), FoodsItemClickListener {

    private val binding: FragmentMainScreenBinding by lazy {
        FragmentMainScreenBinding.inflate(layoutInflater)
    }

    private val adapter: FoodsAdapter by lazy {
        FoodsAdapter(this)
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[MainScreenViewModel::class.java]
        setupStatusColors()
        setupDataListeners()
        binding.cvCart.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_foodCartScreenFragment)
        }
    }

    private fun setupDataListeners() {
        viewModel.foodLiveData.observe(viewLifecycleOwner) { foodList ->
            adapter.updateList(foodList)
            binding.foodsRv.adapter = adapter
        }
    }

    private fun setupStatusColors() {
        requireActivity().window.statusBarColor =
            resources.getColor(R.color.onboarding_btn_background)
        requireActivity().window.navigationBarColor = resources.getColor(R.color.white)
    }

    override fun onFoodItemClick(foodModel: FoodModel) {
        findNavController().navigate(
            R.id.action_mainScreenFragment_to_foodDetailsFragment,
            bundleOf(FOOD_KEY to foodModel),
        )
    }

    companion object {
        const val FOOD_KEY = "FOOD_KEY"
    }
}