package com.tsci.fake_ecommerce.features.register

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dogancan.core.base.platform.BaseFragment
import com.dogancan.core.base.platform.BaseViewModel
import com.dogancan.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentRegisterBinding
import com.tsci.ui.extension.makeLinks
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private val binding: FragmentRegisterBinding by viewBinding()

    override fun initView() {
        binding.tvToLogin.makeLinks(
            Pair(
                getString(R.string.to_login_highlighted_text), View.OnClickListener{
                    findNavController().navigate(
                        RegisterFragmentDirections.toLoginFragment()
                    )
                }
            )
        )
    }

    override fun layoutRes(): Int = R.layout.fragment_register
    override fun viewModel(): BaseViewModel = viewModel
}