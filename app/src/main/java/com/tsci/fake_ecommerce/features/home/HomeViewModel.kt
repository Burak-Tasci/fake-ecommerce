package com.tsci.fake_ecommerce.features.home

import androidx.lifecycle.viewModelScope
import com.dogancan.core.base.platform.BaseViewModel
import com.tsci.ui.model.product.ProductUiModel
import com.tsci.usecase.product.IGetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProductsUseCase: IGetAllProductsUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState: StateFlow<UiState> = _uiState

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        viewModelScope.launch {
            invokeUseCase(
                getAllProductsUseCase.getAllProducts(),
                onSuccess = { productList ->
                    _uiState.update {
                        UiState.Success(productList)
                    }
                },
                onError = { throwable ->
                    _uiState.update {
                        UiState.Error(throwable)
                    }
                }
            )
        }
    }

    sealed interface UiState {
        data class Success(val data: List<ProductUiModel>) : UiState
        object Loading : UiState
        data class Error(val error: Throwable) : UiState
        object Empty : UiState
    }
}