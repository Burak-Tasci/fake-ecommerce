package com.tsci.fake_ecommerce.features.login

import androidx.lifecycle.viewModelScope
import com.dogancan.core.base.platform.BaseViewModel
import com.tsci.fake_ecommerce.features.login.state.LoginUiState
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

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val uiState: StateFlow<LoginUiState> = _uiState

    private var loginUiModel: LoginUiModel

    init {
        loginUiModel = LoginUiModel(username = "", password = "")
    }

    fun login() = viewModelScope.launch {
        invokeUseCase(
            loginUseCase.login(loginUiModel),
            onSuccess = {
                updateUiState(LoginUiState.Success(loginUiModel))
            },
            onError = {
                updateUiState(LoginUiState.Error(it))
            }
        )
    }

    private fun updateUiState(result: LoginUiState) {
        _uiState.update {
            when (result) {
                is LoginUiState.Success -> LoginUiState.Success(result.data)
                is LoginUiState.Error -> LoginUiState.Error(result.error)
                else -> LoginUiState.Error(UnknownError())
            }
        }
    }

    fun clearUiState() {
        _uiState.update {
            LoginUiState.Empty
        }
    }

    fun setUsername(username: CharSequence?) {
        loginUiModel = loginUiModel.copy(username = username.toString())
    }

    fun setPassword(password: CharSequence?) {
        loginUiModel = loginUiModel.copy(password = password.toString())
    }



}