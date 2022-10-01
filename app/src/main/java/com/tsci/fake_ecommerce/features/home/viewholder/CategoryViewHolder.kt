package com.tsci.fake_ecommerce.features.home.viewholder

import com.dogancan.core.base.adapter.BaseViewHolder
import com.tsci.fake_ecommerce.databinding.ItemProductCategoryBinding

class CategoryViewHolder(binding: ItemProductCategoryBinding): BaseViewHolder<ItemProductCategoryBinding, String>(binding) {
    override fun bind(item: String) {
        binding.category = item
    }
}