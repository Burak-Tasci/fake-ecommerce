package com.tsci.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsci.core.base.adapter.BaseListAdapter
import com.tsci.ui.databinding.ItemProductCategoryBinding
import com.tsci.ui.model.category.CategoryUiModel
import com.tsci.ui.viewholder.CategoryViewHolder

class CategoriesAdapter(
    private val onCategoryClick: (position: Int) -> Unit,

) : BaseListAdapter<CategoryUiModel>(
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
        (holder as CategoryViewHolder).apply {
            bind(getItem(position))
            registerClickListener(onCategoryClick)
            onCategoryClickListener(position)
        }

    }

}
