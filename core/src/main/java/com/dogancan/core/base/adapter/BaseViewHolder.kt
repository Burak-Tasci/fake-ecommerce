package com.dogancan.core.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : ViewDataBinding, Item>(
    val binding: T
) : RecyclerView.ViewHolder(binding.root){
    abstract fun bind(item: Item)
}
