package com.tsci.fake_ecommerce.features.register

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentRegisterBinding
import com.tsci.fake_ecommerce.extensions.*
import com.tsci.fake_ecommerce.helpers.PermissionHelper
import com.tsci.ui.extension.makeLinks
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private val binding: FragmentRegisterBinding by viewBinding()

    override fun initView() {
        binding.viewModel = viewModel
        binding.tvToLogin.makeLinks(
            Pair(
                getString(R.string.to_login_highlighted_text), View.OnClickListener {
                    findNavController().navigate(
                        RegisterFragmentDirections.toLoginFragment()
                    )
                }
            )
        )

        viewModel.uiState.collects(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is RegisterViewModel.UiState.Success -> {
                    viewModel.setLoadingState(false)
                    toast(uiState.data.toString())
                }
                is RegisterViewModel.UiState.Loading -> {
                    viewModel.setLoadingState(true)
                }
                is RegisterViewModel.UiState.Error -> {
                    viewModel.setLoadingState(false)
                    toast(uiState.error.localizedMessage)
                }
                is RegisterViewModel.UiState.Empty -> {}
            }
        }

        viewModel.locationState.collects(viewLifecycleOwner) { address ->
            if (address.isNotEmpty()) {
                binding.etLocation.setText(address)
            }
        }
    }

    override fun initListeners()  {
        binding.btnLocate.setOnClickListener {
            locateUser()
        }
        binding.btnRegister.setOnClickListener {
            if (viewModel.isRegistrationValid()){
                viewModel.register()
            } else {
                toast("Invalid registration.")
            }
        }
        binding.etLocation.setOnClickListener {
            // todo open a dialog to handle address variables from here
        }
    }

    private fun locateUser() {
        if (PermissionHelper.hasAccessFineLocation(requireActivity())) {
            viewModel.locateUser()
        } else {
            PermissionHelper.requestAccessFineLocation(requireActivity(),
                object : PermissionHelper.PermissionResponse {
                    override fun onPermissionAccepted() {
                        viewModel.locateUser()
                    }

                    override fun onPermissionDenied() {
                        requireView().snack(getString(R.string.location_permission)) {
                            action(getString(R.string.settings)) {
                                openApplicationDetailSettings(requireContext())
                            }
                        }
                    }
                }
            )
        }
    }

    override fun layoutRes(): Int = R.layout.fragment_register
    override fun viewModel(): BaseViewModel = viewModel
}