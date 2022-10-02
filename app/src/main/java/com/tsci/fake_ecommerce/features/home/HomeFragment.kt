package com.tsci.fake_ecommerce.features.home

import androidx.fragment.app.viewModels
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentHomeBinding
import com.tsci.fake_ecommerce.extensions.collects
import com.tsci.fake_ecommerce.extensions.toast
import com.tsci.fake_ecommerce.features.home.adapter.CategoriesAdapter
import com.tsci.fake_ecommerce.features.home.adapter.ProductsAdapter
import com.tsci.fake_ecommerce.features.home.state.CategoriesUiState
import com.tsci.fake_ecommerce.features.home.state.ProductsUiState
import com.tsci.ui.model.category.CategoryUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: FragmentHomeBinding by viewBinding()

    private val mProductsAdapter = ProductsAdapter()
    private val mCategoriesAdapter = CategoriesAdapter(::onCategoryClick)

    override fun initView() {
        binding.rvProducts.adapter = mProductsAdapter
        binding.toolbar.rvCategories.adapter = mCategoriesAdapter
    }

    override fun initCollectors() {
        viewModel.productsUiState.collects(viewLifecycleOwner) { result ->
            when (result) {
                is ProductsUiState.Success -> {
                    mProductsAdapter.submitList(result.data)
                }
                is ProductsUiState.Error -> {
                    toast(result.error.localizedMessage)
                }
            }
        }
        viewModel.categoriesUiState.collects(viewLifecycleOwner) { result ->
            when (result) {
                is CategoriesUiState.Success -> {
                    mCategoriesAdapter.submitList(
                        listOf(CategoryUiModel(category = "All", checked = true)) + result.data
                    )
                }
                is CategoriesUiState.Error -> {
                    toast(result.error.localizedMessage)
                }
            }
        }
    }
    private fun onCategoryClick(position: Int){
        val currentList = mCategoriesAdapter.currentList.toMutableList()
        currentList.forEach {
            if (it.checked){
                if ( currentList.indexOf(it) == position) { return }
                currentList[currentList.indexOf(it)] = it.copy(checked = false)
            }
        }
        currentList[position] = currentList[position].copy(checked = true)
        mCategoriesAdapter.submitList(currentList)
    }

    override fun layoutRes(): Int = R.layout.fragment_home
    override fun viewModel(): BaseViewModel = viewModel


}