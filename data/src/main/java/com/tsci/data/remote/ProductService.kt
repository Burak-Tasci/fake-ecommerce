package com.tsci.data.remote

import com.skydoves.sandwich.ApiResponse
import com.tsci.entity.product.ProductEntityModel
import retrofit2.http.GET

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
interface ProductService {

    @GET(PRODUCTS)
    suspend fun getAllProducts(): ApiResponse<List<ProductEntityModel>>


    companion object{
        private const val PRODUCTS = "products"
    }
}