package com.tsci.ui.viewholder

import com.tsci.core.base.adapter.BaseViewHolder
import com.tsci.ui.databinding.ItemProductBinding
import com.tsci.ui.model.product.ProductUiModel

/**
 * Created by Burak Taşcı on 29.09.2022.
 */
class ProductViewHolder(binding: ItemProductBinding): BaseViewHolder<ItemProductBinding, ProductUiModel>(binding) {

    private lateinit var onClickListener: (id: Int) -> Unit

    override fun bind(item: ProductUiModel) {
        binding.product = item
    }
    fun registerClickListener(listener: (position: Int) -> Unit){
        onClickListener = listener
    }

    fun onProductClickListener(position: Int){
        binding.root.setOnClickListener {
            onClickListener.invoke(position)
        }
    }
}