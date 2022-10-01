package com.tsci.fake_ecommerce.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dogancan.core.base.adapter.BaseListAdapter
import com.tsci.fake_ecommerce.databinding.ItemProductCategoryBinding
import com.tsci.fake_ecommerce.features.home.viewholder.CategoryViewHolder

class CategoriesAdapter : BaseListAdapter<String>(
    itemsSame = {old, new -> old == new},
    contentsSame = {old, new -> old.equals(new)},
){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ItemProductCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryViewHolder).bind(getItem(position))
    }

}
