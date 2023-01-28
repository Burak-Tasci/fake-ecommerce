package com.tsci.fake_ecommerce.features.login

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tsci.core.base.platform.BaseFragment
import com.tsci.core.base.platform.BaseViewModel
import com.tsci.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.MainActivity
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentLoginBinding
import com.tsci.fake_ecommerce.extensions.collects
import com.tsci.fake_ecommerce.extensions.toast
import com.tsci.fake_ecommerce.features.login.state.LoginUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels()
    private val binding: FragmentLoginBinding by viewBinding()

    private val args by navArgs<LoginFragmentArgs>()
    override fun initView() {
        binding.viewModel = viewModel
        binding.etUserName.setText(args.username)
    }

    override fun initListeners() {
        binding.toolbar.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnLogin.setOnClickListener {
            viewModel.login()
        }
    }

    override fun initCollectors() {
        viewModel.uiState.collects(viewLifecycleOwner){ uiState ->
            when(uiState){
                is LoginUiState.Success -> {
                    viewModel.clearUiState()
                   (requireActivity() as MainActivity).setNavigationGraph(R.navigation.nav_graph_main)
                }
                is LoginUiState.Error -> {
                    toast(uiState.error.message)
                }
                is LoginUiState.Empty -> {}
            }
        }
    }


    override fun layoutRes(): Int = R.layout.fragment_login
    override fun viewModel(): BaseViewModel = viewModel
}