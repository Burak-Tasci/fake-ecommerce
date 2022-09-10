package com.tsci.entity.product

data class ProductEntityModel(
    val id: Int?,
    val category: String?,
    val description: String?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?
)