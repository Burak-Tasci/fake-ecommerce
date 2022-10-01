package com.tsci.fake_ecommerce.features.home

import androidx.lifecycle.viewModelScope
import com.dogancan.core.base.platform.BaseViewModel
import com.tsci.fake_ecommerce.features.home.state.ProductsUiState
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

    private val _productsUiState = MutableStateFlow<ProductsUiState>(ProductsUiState.Empty)
    val productsUiState: StateFlow<ProductsUiState> = _productsUiState

    private val _categoriesUiState = MutableStateFlow<ProductsUiState>(ProductsUiState.Empty)
    val categoriesUiState: StateFlow<ProductsUiState> = _categoriesUiState

    init {
        getAllProducts()

    }

    fun getAllProducts() {
        viewModelScope.launch {
            invokeUseCase(
                getAllProductsUseCase.getAllProducts(),
                onSuccess = { productList ->
                    _productsUiState.update {
                        ProductsUiState.Success(productList)
                    }
                },
                onError = { throwable ->
                    _productsUiState.update {
                        ProductsUiState.Error(throwable)
                    }
                }
            )
        }
    }
    fun getCategories(){
        viewModelScope.launch {
            
        }
    }

}