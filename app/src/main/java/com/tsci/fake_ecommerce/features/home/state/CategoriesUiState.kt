package com.tsci.fake_ecommerce.features.home.state

sealed interface CategoriesUiState{
    data class Success(val data: List<String>) : CategoriesUiState
    object Loading : CategoriesUiState
    data class Error(val error: Throwable) : CategoriesUiState
    object Empty : CategoriesUiState
}