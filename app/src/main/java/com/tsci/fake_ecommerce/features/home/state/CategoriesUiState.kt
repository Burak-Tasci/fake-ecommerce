package com.tsci.fake_ecommerce.features.home.state

import com.tsci.ui.model.category.CategoryUiModel

sealed interface CategoriesUiState{
    data class Success(val data: List<CategoryUiModel>) : CategoriesUiState
    object Loading : CategoriesUiState
    data class Error(val error: Throwable) : CategoriesUiState
    object Empty : CategoriesUiState
}