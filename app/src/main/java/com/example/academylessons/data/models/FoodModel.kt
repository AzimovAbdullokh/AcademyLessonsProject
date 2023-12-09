package com.example.academylessons.data.models

import java.io.Serializable

data class FoodModel(
    val foodName: String,
    val foodDescription: String,
    val foodPrice: Int,
    val foodImage: String,
) : Serializable
