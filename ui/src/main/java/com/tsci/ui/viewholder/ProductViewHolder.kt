package com.tsci.ui.viewholder

import com.dogancan.core.base.adapter.BaseViewHolder
import com.tsci.ui.databinding.ItemProductBinding
import com.tsci.ui.model.product.ProductUiModel

/**
 * Created by Burak Taşcı on 29.09.2022.
 */
class ProductViewHolder(binding: ItemProductBinding): BaseViewHolder<ItemProductBinding, ProductUiModel>(binding) {
    override fun bind(item: ProductUiModel) {
        binding.product = item
    }
}