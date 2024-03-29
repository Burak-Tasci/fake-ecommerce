package com.tsci.fake_ecommerce.features.register

import android.location.Location
import androidx.lifecycle.viewModelScope
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.exception.LocationNotFoundException
import com.tsci.fake_ecommerce.features.register.state.RegisterUiState
import com.tsci.fake_ecommerce.helpers.LocationHelper
import com.tsci.ui.model.auth.RegisterUiModel
import com.tsci.usecase.register.IRegisterUseCase
import com.tsci.usecase.register.IRegisterValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: IRegisterUseCase,
    private val registerValidationUseCase: IRegisterValidationUseCase,
    private val locationUtils: LocationHelper
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Empty)
    val uiState: StateFlow<RegisterUiState> = _uiState

    private var registerUiModel: RegisterUiModel

    private val _locationState = MutableStateFlow("")
    val locationState: StateFlow<String> = _locationState


    // todo add dialog to change address properties
    init {
        registerUiModel = RegisterUiModel(
            city = "",
            email = "",
            lat = "",
            long = "",
            name = "",
            number = -1,
            password = "",
            phoneNumber = "",
            street = "",
            surname = "",
            username = "",
            zipcode = ""
        )

    }

    fun register() = viewModelScope.launch {
        invokeUseCase(
            registerUseCase.register(registerUiModel),
            onSuccess = {
                updateUiState(RegisterUiState.Success(registerUiModel))
            },
            onError = { result ->
                updateUiState(RegisterUiState.Error(result))
            }
        )
    }

    fun isRegistrationValid(): Boolean = registerValidationUseCase.validate(registerUiModel)

    private fun updateUiState(result: RegisterUiState) {
        _uiState.update {
            when (result) {
                is RegisterUiState.Success -> RegisterUiState.Success(result.data)
                is RegisterUiState.Error -> RegisterUiState.Error(result.error)
                else -> RegisterUiState.Error(UnknownError())
            }
        }
    }


    fun setEmail(email: CharSequence?) {
        registerUiModel = registerUiModel.copy(email = email.toString())
    }

    fun setName(name: CharSequence?) {
        registerUiModel = registerUiModel.copy(name = name.toString())
    }

    fun setSurname(surname: CharSequence?) {
        registerUiModel = registerUiModel.copy(surname = surname.toString())
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

    fun setAddress(address: CharSequence?) {
        _locationState.update {
            address.toString()
        }
    }

    fun locateUser() {
        locationUtils.getLastKnownLocation(object : LocationHelper.DefaultLocationListener {
            override fun onLocationUpdate(location: Location) {
                val address = locationUtils.getAddressFromLocationLatLng(
                    location.latitude,
                    location.longitude
                )

                registerUiModel = registerUiModel.copy(
                    city = address.adminArea ?: address.subAdminArea,
                    lat = address.latitude.toString(),
                    long = address.longitude.toString(),
                    zipcode = address.postalCode,
                    street = address.thoroughfare,
                    number = address.featureName.toInt()
                )

                setAddress(address.getAddressLine(0))

            }

            override fun onLocationNotFound() {
                updateUiState(
                    RegisterUiState.Error(LocationNotFoundException())
                )
            }
        })
    }

    fun clearUiState() {
        _uiState.update {
            RegisterUiState.Empty
        }
    }


}