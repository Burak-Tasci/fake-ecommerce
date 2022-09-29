package com.tsci.data.repository

import com.dogancan.core.base.network.BaseRepository
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
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
        val data = productService.getAllProducts()
        data.onSuccess {
            Result.success(this)
        }.onFailure {
            Result.failure<Exception>(Exception(this))
        }
    }.flowOn(ioScope)
}