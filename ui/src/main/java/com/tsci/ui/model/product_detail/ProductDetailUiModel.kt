package com.tsci.ui.model.product_detail

/**
 * Created by Burak Taşcı on 4.12.2022.
 */
data class ProductDetailUiModel(
    val id: Int,
    val category: String,
    val image: String,
    val price: Double,
    val ratingAverage: Double,
    val title: String,
    val description: String
)
