package com.tsci.fake_ecommerce.features.home

import android.os.Parcelable
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tsci.core.base.platform.BaseFragment
import com.tsci.core.base.platform.BaseViewModel
import com.tsci.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentHomeBinding
import com.tsci.fake_ecommerce.extensions.collects
import com.tsci.fake_ecommerce.extensions.toast
import com.tsci.fake_ecommerce.features.home.state.CategoriesUiState
import com.tsci.fake_ecommerce.features.home.state.ProductsUiState
import com.tsci.ui.adapter.CategoriesAdapter
import com.tsci.ui.adapter.ProductsAdapter
import com.tsci.ui.model.category.CategoryUiModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var productsRecyclerViewState: Parcelable? = null

    private val viewModel: HomeViewModel by viewModels()
    private val binding: FragmentHomeBinding by viewBinding()

    private val mProductsAdapter = ProductsAdapter(::onProductClick)
    private val mCategoriesAdapter = CategoriesAdapter(::onCategoryClick)

    override fun initView() {

        binding.toolbar.rvCategories.adapter = mCategoriesAdapter
        binding.rvProducts.adapter = mProductsAdapter

    }
    override fun onPause() {
        super.onPause()
        productsRecyclerViewState = binding.rvProducts.layoutManager?.onSaveInstanceState()
    }

    override fun onResume() {
        super.onResume()
        binding.rvProducts.layoutManager?.onRestoreInstanceState(productsRecyclerViewState)
    }

    override fun initCollectors() {
        viewModel.productsUiState.collects(viewLifecycleOwner) { result ->
            when (result) {
                is ProductsUiState.Success -> {
                    mProductsAdapter.submitList(result.data)
                    viewModel.clearProductsUiState()
                }
                is ProductsUiState.Error -> {
                    toast(result.error.localizedMessage)
                }
                is ProductsUiState.Empty -> { }
            }
        }
        viewModel.categoriesUiState.collects(viewLifecycleOwner) { result ->
            when (result) {
                is CategoriesUiState.Success -> {
                    mCategoriesAdapter.submitList(
                        listOf(CategoryUiModel(category = CATEGORY_ALL, checked = true)) + result.data
                    )
                    viewModel.clearCategoriesUiState()
                }
                is CategoriesUiState.Error -> {
                    toast(result.error.localizedMessage)
                }
            }
        }

    }



    private fun onCategoryClick(position: Int) {
        val currentList = mCategoriesAdapter.currentList.toMutableList()
        refreshCategories(currentList, position)
        filterProducts(currentList[position])
    }
    private fun onProductClick(id: Int){
        findNavController().navigate(
            HomeFragmentDirections.toProductDetailFragment(id)
        )
    }

    private fun refreshCategories(currentList: MutableList<CategoryUiModel>,position: Int){
        currentList.forEach {
            if (it.checked) {
                if (currentList.indexOf(it) == position) {
                    return
                }
                currentList[currentList.indexOf(it)] = it.copy(checked = false)
            }
        }
        currentList[position] = currentList[position].copy(checked = true)
        mCategoriesAdapter.submitList(currentList)
    }
    private fun filterProducts(item: CategoryUiModel){
        when(item.category){
            CATEGORY_ALL -> {
                viewModel.getAllProducts()
            }
            else -> {
                viewModel.getProductsByCategory(item.category)
            }
        }
    }


    override fun layoutRes(): Int = R.layout.fragment_home
    override fun viewModel(): BaseViewModel = viewModel

    companion object {
        const val CATEGORY_ALL = "All"
    }
}