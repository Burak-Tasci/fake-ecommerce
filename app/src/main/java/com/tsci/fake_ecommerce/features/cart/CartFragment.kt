package com.tsci.fake_ecommerce.features.cart

import androidx.fragment.app.viewModels
import com.tsci.core.base.platform.BaseFragment
import com.tsci.core.base.platform.BaseViewModel
import com.tsci.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment() {

    private val viewModel : CartViewModel by viewModels()
    private val binding : FragmentCartBinding by viewBinding()

    override fun initView() {

    }

    override fun layoutRes(): Int = R.layout.fragment_cart
    override fun viewModel(): BaseViewModel = viewModel


}