package com.example.academylessons.data.repository

import com.example.academylessons.data.fake_data.foodFakeDatas
import com.example.academylessons.data.models.FoodModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllFoodsRepositoryImpl : GetAllFoodsRepository {

    override suspend fun getAllFoodsAsync(): List<FoodModel> =
        withContext(Dispatchers.IO) {
            foodFakeDatas()
        }
}