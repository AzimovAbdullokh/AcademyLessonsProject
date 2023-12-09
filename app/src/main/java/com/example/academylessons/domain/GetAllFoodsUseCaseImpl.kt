package com.example.academylessons.domain

import com.example.academylessons.data.models.FoodModel
import com.example.academylessons.data.repository.GetAllFoodsRepositoryImpl

class GetAllFoodsUseCaseImpl : GetAllFoodsUseCase {

    private val foodsRepository = GetAllFoodsRepositoryImpl()


    override suspend fun getAllFoods(): List<FoodModel> {
        return foodsRepository.getAllFoodsAsync()
    }
}