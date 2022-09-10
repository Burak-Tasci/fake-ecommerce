package com.tsci.fake_ecommerce.features.register

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentRegisterBinding
import com.tsci.fake_ecommerce.extensions.collects
import com.tsci.ui.extension.makeLinks
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private val binding: FragmentRegisterBinding by viewBinding()

    override fun initView() = with(binding) {
        this.viewModel = this@RegisterFragment.viewModel
        tvToLogin.makeLinks(
            Pair(
                getString(R.string.to_login_highlighted_text), View.OnClickListener {
                    findNavController().navigate(
                        RegisterFragmentDirections.toLoginFragment()
                    )
                }
            )
        )

        this@RegisterFragment.viewModel.uiState.collects(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is RegisterViewModel.UiState.Success -> {
                    this@RegisterFragment.viewModel.setLoadingState(false)
                    Toast.makeText(requireContext(), uiState.data.toString(), Toast.LENGTH_LONG).show()
                }
                is RegisterViewModel.UiState.Loading -> {
                    this@RegisterFragment.viewModel.setLoadingState(true)
                }
                is RegisterViewModel.UiState.Error -> {
                    this@RegisterFragment.viewModel.setLoadingState(false)
                    Toast.makeText(requireContext(), uiState.errorMessage , Toast.LENGTH_LONG).show()
                }
            }
        }
        Unit
    }

    override fun initListeners() = with(binding) {
        btnRegister.setOnClickListener {
            this@RegisterFragment.viewModel.register()
        }
    }

    override fun layoutRes(): Int = R.layout.fragment_register
    override fun viewModel(): BaseViewModel = viewModel
}