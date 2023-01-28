package com.tsci.fake_ecommerce.features.product_detail

import androidx.fragment.app.viewModels
import com.tsci.core.base.platform.BaseFragment
import com.tsci.core.base.platform.BaseViewModel
import com.tsci.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment() {

    private val binding by viewBinding<FragmentProductDetailBinding>()
    private val viewModel by viewModels<ProductDetailViewModel>()

    override fun initView() {

    }

    override fun layoutRes(): Int = R.layout.fragment_product_detail
    override fun viewModel(): BaseViewModel = viewModel


}