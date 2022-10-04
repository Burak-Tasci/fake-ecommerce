package com.tsci.usecase.product

import com.tsci.data.repository.ProductRepository
import com.tsci.ui.model.product.ProductUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetProductsByCategoryUseCase @Inject constructor(
    private val repository: ProductRepository,
    private val mapper: ProductListMapper
): IGetProductsByCategoryUseCase {
    override suspend fun getProductsByCategory(category: String): Flow<Result<List<ProductUiModel>>> =
        repository.getProductsByCategory(category).map { result ->
            result.map {
                mapper.map(it)
            }
        }
}