package com.tsci.fake_ecommerce.features.login.state

import com.tsci.ui.model.auth.LoginUiModel

sealed interface LoginUiState {
    data class Success(val data: LoginUiModel) : LoginUiState
    object Loading : LoginUiState
    data class Error(val error: Throwable) : LoginUiState
    object Empty : LoginUiState

}