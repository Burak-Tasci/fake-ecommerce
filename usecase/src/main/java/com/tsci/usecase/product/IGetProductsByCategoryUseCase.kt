package com.tsci.usecase.product

import com.tsci.ui.model.product.ProductUiModel
import kotlinx.coroutines.flow.Flow

interface IGetProductsByCategoryUseCase {
    suspend fun getProductsByCategory(category: String): Flow<Result<List<ProductUiModel>>>
}