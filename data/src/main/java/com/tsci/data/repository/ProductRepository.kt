package com.tsci.data.repository

import com.dogancan.core.base.network.BaseRepository
import com.tsci.data.di.IoDispatcher
import com.tsci.data.remote.ProductService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
class ProductRepository @Inject constructor(
    private val productService: ProductService,
    @IoDispatcher private val ioScope: CoroutineDispatcher
): BaseRepository() {

    suspend fun getAllProducts() = invoke {
        productService.getAllProducts()
    }.flowOn(ioScope)

    suspend fun getCategories() = invoke {
        productService.getCategories()
    }.flowOn(ioScope)
}