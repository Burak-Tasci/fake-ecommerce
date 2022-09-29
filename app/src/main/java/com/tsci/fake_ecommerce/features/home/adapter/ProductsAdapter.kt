package com.tsci.fake_ecommerce.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dogancan.core.base.adapter.BaseListAdapter
import com.tsci.fake_ecommerce.databinding.ItemProductBinding
import com.tsci.fake_ecommerce.features.home.viewholder.ProductViewHolder
import com.tsci.ui.model.product.ProductUiModel

/**
 * Created by Burak Taşcı on 29.09.2022.
 */
class ProductsAdapter : BaseListAdapter<ProductUiModel>(
    itemsSame = { old, new -> old == new },
    contentsSame = { old, new -> old.equals(new) }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).bind(getItem(position))
    }

}