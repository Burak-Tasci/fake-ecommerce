package com.tsci.fake_ecommerce.features.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentLoginBinding
import com.tsci.fake_ecommerce.extensions.collects
import com.tsci.fake_ecommerce.extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()
    private val binding: FragmentLoginBinding by viewBinding()

    private val args by navArgs<LoginFragmentArgs>()
    override fun initView() {
        binding.viewModel = viewModel
        binding.etUserName.setText(args.username)
        viewModel.uiState.collects(viewLifecycleOwner){ uiState ->
            when(uiState){
                is LoginViewModel.UiState.Success -> {
                    viewModel.setLoadingState(false)
                    viewModel.clearUiState()
                    toast(uiState.data.toString())
                }
                is LoginViewModel.UiState.Loading -> {
                    viewModel.setLoadingState(true)
                }
                is LoginViewModel.UiState.Error -> {
                    viewModel.setLoadingState(false)
                    toast(uiState.error.localizedMessage)
                }
                is LoginViewModel.UiState.Empty -> {}
            }
        }
    }

    override fun initListeners() {
        binding.toolbar.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnLogin.setOnClickListener {
            viewModel.login()
        }
    }


    override fun layoutRes(): Int = R.layout.fragment_login
    override fun viewModel(): BaseViewModel = viewModel
}