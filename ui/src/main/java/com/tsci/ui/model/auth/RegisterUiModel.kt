package com.tsci.ui.model.auth

import com.tsci.entity.auth.Address
import com.tsci.entity.auth.Name

data class RegisterUiModel(
    val address: Address,
    val email: String,
    val name: Name,
    val password: String,
    val phone: String,
    val username: String
)