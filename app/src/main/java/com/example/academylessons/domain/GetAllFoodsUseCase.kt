package com.example.academylessons.domain

import com.example.academylessons.data.models.FoodModel

interface GetAllFoodsUseCase {
    suspend fun getAllFoods(): List<FoodModel>
}