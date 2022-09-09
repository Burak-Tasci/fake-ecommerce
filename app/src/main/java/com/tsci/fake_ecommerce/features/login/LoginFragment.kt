package com.tsci.fake_ecommerce.features.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()
    private val binding: FragmentLoginBinding by viewBinding()

    override fun initView() {

    }

    override fun initListeners() = with(binding) {
        toolbar.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }



    override fun layoutRes(): Int = R.layout.fragment_login
    override fun viewModel(): BaseViewModel = viewModel
}