package com.tsci.usecase.product

import com.tsci.data.repository.ProductRepository
import com.tsci.ui.model.product.ProductUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 26.09.2022.
 */
class GetAllProductsUseCase @Inject constructor(
    private val mapper: ProductListMapper,
    private val repository: ProductRepository
) : IGetAllProductsUseCase {
    override suspend fun getAllProducts(): Flow<Result<List<ProductUiModel>>> =
        repository.getAllProducts().map { response ->
            response.map {
                mapper.map(it)
            }
        }
}