package com.tsci.usecase.product

import com.tsci.ui.model.product.ProductUiModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by Burak Taşcı on 26.09.2022.
 */
interface IGetAllProductsUseCase {
    suspend fun getAllProducts(): Flow<Result<List<ProductUiModel>>>
}