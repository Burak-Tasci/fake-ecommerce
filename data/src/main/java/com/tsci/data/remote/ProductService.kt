package com.tsci.data.remote

import com.skydoves.sandwich.ApiResponse
import com.tsci.entity.product.ProductEntityModel
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
interface ProductService {

    @GET(ENDPOINT_PRODUCTS)
    suspend fun getAllProducts(): ApiResponse<List<ProductEntityModel>>

    @GET(ENDPOINT_CATEGORIES)
    suspend fun getCategories(): ApiResponse<List<String>>

    @GET(ENDPOINT_PRODUCTS_BY_CATEGORY)
    suspend fun getProductsByCategory(@Path(PATH_CATEGORY) category: String): ApiResponse<List<ProductEntityModel>>

    companion object{
        private const val PATH_CATEGORY = "category"

        private const val ENDPOINT_PRODUCTS = "products"
        private const val ENDPOINT_CATEGORIES = "products/categories"
        private const val ENDPOINT_PRODUCTS_BY_CATEGORY = "products/category/{$PATH_CATEGORY}"
    }
}