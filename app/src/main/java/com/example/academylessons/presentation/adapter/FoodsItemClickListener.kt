package com.example.academylessons.presentation.adapter

import com.example.academylessons.data.models.FoodModel

interface FoodsItemClickListener {
    fun onFoodItemClick(foodModel: FoodModel)
}