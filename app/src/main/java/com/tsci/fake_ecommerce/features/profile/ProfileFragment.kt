package com.tsci.fake_ecommerce.features.profile

import androidx.fragment.app.viewModels
import com.tsci.core.base.platform.BaseFragment
import com.tsci.core.base.platform.BaseViewModel
import com.tsci.core.utils.binding.viewBinding
import com.tsci.fake_ecommerce.R
import com.tsci.fake_ecommerce.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment() {

    private val viewModel : ProfileViewModel by viewModels()
    private val binding : FragmentProfileBinding by viewBinding()

    override fun initView() {

    }

    override fun layoutRes(): Int = R.layout.fragment_profile
    override fun viewModel(): BaseViewModel = viewModel

}