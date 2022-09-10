package com.tsci.entity.cart

data class CartEntityModel(
    val id: Int?,
    val date: String?,
    val products: List<CardProduct>?,
    val userId: Int?
)