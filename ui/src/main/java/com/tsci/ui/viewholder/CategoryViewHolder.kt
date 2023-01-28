package com.tsci.ui.viewholder

import com.dogancan.core.base.adapter.BaseViewHolder
import com.tsci.ui.databinding.ItemProductCategoryBinding
import com.tsci.ui.model.category.CategoryUiModel

class CategoryViewHolder(binding: ItemProductCategoryBinding): BaseViewHolder<ItemProductCategoryBinding, CategoryUiModel>(binding) {

    private lateinit var onClickListener: (position: Int) -> Unit

    override fun bind(item: CategoryUiModel) {
        binding.item = item
    }

    fun registerClickListener(listener: (position: Int) -> Unit){
        onClickListener = listener
    }

    fun onCategoryClickListener(position: Int){
        binding.root.setOnClickListener {
            onClickListener.invoke(position)
        }
    }
}