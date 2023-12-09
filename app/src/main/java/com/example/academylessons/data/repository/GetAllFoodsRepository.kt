package com.example.academylessons.data.repository

import com.example.academylessons.data.models.FoodModel

interface GetAllFoodsRepository {
    suspend fun getAllFoodsAsync(): List<FoodModel>
}