package com.example.academylessons.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.academylessons.R
import com.example.academylessons.data.models.FoodModel
import com.example.academylessons.databinding.FoodItemBinding

class FoodsAdapter(
    private val listener: FoodsItemClickListener,
) : RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder>() {

    private var foodList = mutableListOf<FoodModel>()

    fun updateList(foodList: List<FoodModel>) {
        this.foodList.clear()
        this.foodList.addAll(foodList)
        notifyDataSetChanged()
    }

    inner class FoodsViewHolder(private val binding: FoodItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodModel: FoodModel) {
            binding.apply {
                foodName.text = foodModel.foodName
                foodDescription.text = foodModel.foodDescription
                foodPrice.text = "${foodModel.foodPrice}$"
                itemCard.setOnClickListener {
                    listener.onFoodItemClick(foodModel)
                }
                Glide.with(root).load(foodModel.foodImage).into(foodPhoto)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int,
    ): FoodsViewHolder {
        val binding = FoodItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        )
        return FoodsViewHolder(binding)
    }

    override fun getItemCount(): Int = foodList.size


    override fun onBindViewHolder(
        holder: FoodsViewHolder,
        position: Int,
    ) {
        holder.bind(foodList[position])
    }
}
