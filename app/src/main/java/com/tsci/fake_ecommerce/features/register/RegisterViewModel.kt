package com.tsci.fake_ecommerce.features.register

import androidx.lifecycle.viewModelScope
import com.dogancan.core.base.platform.BaseViewModel
import com.tsci.entity.auth.Name
import com.tsci.ui.model.auth.RegisterUiModel
import com.tsci.usecase.register.IRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: IRegisterUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState: StateFlow<UiState> = _uiState

    private var registerUiModel: RegisterUiModel

    init {
        registerUiModel = RegisterUiModel(
            address = "",
            email = "",
            name = Name("", ""),
            password = "",
            username = "",
            phoneNumber = ""
        )
    }

    fun register() = viewModelScope.launch {
        invokeUseCase(
            registerUseCase.register(registerUiModel),
            onSuccess = {
                updateUiState(UiState.Success(true))
            },
            onError = { result ->
                updateUiState(UiState.Error(result.localizedMessage ?: "An error occurred!"))
            }
        )
    }

    private fun updateUiState(result: UiState) {
        _uiState.update {
            when (result) {
                is UiState.Success -> UiState.Success(result.data)
                is UiState.Error -> UiState.Error(result.errorMessage)
                else -> UiState.Error("Unexpected behaviour.")
            }
        }
    }

    fun setAddress(address: CharSequence?) {
        registerUiModel = registerUiModel.copy(address = address.toString())
    }

    fun setEmail(email: CharSequence?) {
        registerUiModel = registerUiModel.copy(email = email.toString())
    }

    fun setName(name: CharSequence?) {
        registerUiModel =
            registerUiModel.copy(name = Name(name.toString(), registerUiModel.name.lastname))
    }

    fun setSurname(surname: CharSequence?) {
        registerUiModel =
            registerUiModel.copy(name = Name(registerUiModel.name.firstname, surname.toString()))
    }

    fun setPassword(password: CharSequence?) {
        registerUiModel = registerUiModel.copy(password = password.toString())
    }

    fun setUserName(userName: CharSequence?) {
        registerUiModel = registerUiModel.copy(username = userName.toString())
    }

    fun setPhoneNumber(phoneNumber: CharSequence?) {
        registerUiModel = registerUiModel.copy(phoneNumber = phoneNumber.toString())
    }


    sealed interface UiState {
        data class Success(val data: Boolean) : UiState
        object Loading : UiState
        data class Error(val errorMessage: String) : UiState

        object Empty: UiState
    }
}