package com.tsci.fake_ecommerce.features.home

import androidx.fragment.app.viewModels
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentHomeBinding
import com.tsci.fake_ecommerce.extensions.collects
import com.tsci.fake_ecommerce.extensions.toast
import com.tsci.fake_ecommerce.features.home.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: FragmentHomeBinding by viewBinding()

    private val mProductsAdapter = ProductsAdapter()

    override fun initView() {
        binding.rvProducts.adapter = mProductsAdapter
        viewModel.uiState.collects(viewLifecycleOwner) { result ->
            when (result){
                is HomeViewModel.UiState.Success -> {
                    mProductsAdapter.submitList(result.data)
                }
                is HomeViewModel.UiState.Error -> {
                    toast(result.error.localizedMessage)
                }
            }
        }

    }


    override fun layoutRes(): Int = R.layout.fragment_home
    override fun viewModel(): BaseViewModel = viewModel


}