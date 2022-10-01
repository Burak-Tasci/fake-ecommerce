package com.tsci.fake_ecommerce.features.home.state

import com.tsci.ui.model.product.ProductUiModel

sealed interface ProductsUiState {
    data class Success(val data: List<ProductUiModel>) : ProductsUiState
    object Loading : ProductsUiState
    data class Error(val error: Throwable) : ProductsUiState
    object Empty : ProductsUiState
}