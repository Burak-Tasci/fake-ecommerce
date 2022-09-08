package com.tsci.fake_ecommerce.features.register

import androidx.fragment.app.viewModels
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private val binding: FragmentRegisterBinding by viewBinding()

    override fun initView() {

    }

    override fun layoutRes(): Int = R.layout.fragment_register
    override fun viewModel(): BaseViewModel = viewModel
}