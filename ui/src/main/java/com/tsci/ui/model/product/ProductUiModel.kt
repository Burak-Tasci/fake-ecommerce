package com.tsci.ui.model.product

/**
 * Created by Burak Taşcı on 26.09.2022.
 */
data class ProductUiModel(
    val id: Int,
    val category: String,
    val image: String,
    val price: Double,
    val ratingAverage: Double,
    val title: String
)
