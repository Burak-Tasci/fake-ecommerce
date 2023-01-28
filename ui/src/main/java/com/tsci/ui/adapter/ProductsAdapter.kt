package com.tsci.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsci.core.base.adapter.BaseListAdapter
import com.tsci.ui.databinding.ItemProductBinding
import com.tsci.ui.model.product.ProductUiModel
import com.tsci.ui.viewholder.ProductViewHolder

/**
 * Created by Burak Taşcı on 29.09.2022.
 */
class ProductsAdapter(
    private val onProductClick: (id: Int) -> Unit
) : BaseListAdapter<ProductUiModel>(
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
        val product = getItem(position)
        (holder as ProductViewHolder).apply {
            bind(product)
            registerClickListener(onProductClick)
            onProductClickListener(product.id)
        }
    }

}