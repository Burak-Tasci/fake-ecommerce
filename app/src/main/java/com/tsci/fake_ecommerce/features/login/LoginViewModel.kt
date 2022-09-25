package com.tsci.fake_ecommerce.features.login

import androidx.lifecycle.viewModelScope
import com.dogancan.core.base.platform.BaseViewModel
import com.tsci.ui.model.auth.LoginUiModel
import com.tsci.usecase.login.ILoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: ILoginUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState: StateFlow<UiState> = _uiState

    private var loginUiModel: LoginUiModel

    init {
        loginUiModel = LoginUiModel(username = "", password = "")
    }

    fun login() = viewModelScope.launch {
        invokeUseCase(
            loginUseCase.login(loginUiModel),
            onSuccess = {
                updateUiState(UiState.Success(loginUiModel))
            },
            onError = {
                updateUiState(UiState.Error(it))
            }
        )
    }

    private fun updateUiState(result: UiState) {
        _uiState.update {
            when (result) {
                is UiState.Success -> UiState.Success(result.data)
                is UiState.Error -> UiState.Error(result.error)
                else -> UiState.Error(UnknownError())
            }
        }
    }

    fun clearUiState() {
        _uiState.update {
            UiState.Empty
        }
    }

    fun setUsername(username: CharSequence?) {
        loginUiModel = loginUiModel.copy(username = username.toString())
    }

    fun setPassword(password: CharSequence?) {
        loginUiModel = loginUiModel.copy(password = password.toString())
    }

    sealed interface UiState {
        data class Success(val data: LoginUiModel) : UiState
        object Loading : UiState
        data class Error(val error: Throwable) : UiState
        object Empty : UiState

    }

}