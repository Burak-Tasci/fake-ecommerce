package com.tsci.fake_ecommerce.features.register.state

import com.tsci.ui.model.auth.RegisterUiModel

sealed interface RegisterUiState {
    data class Success(val data: RegisterUiModel) : RegisterUiState
    object Loading : RegisterUiState
    data class Error(val error: Throwable) : RegisterUiState
    object Empty : RegisterUiState

}