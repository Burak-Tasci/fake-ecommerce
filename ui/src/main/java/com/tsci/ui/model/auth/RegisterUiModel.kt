package com.tsci.ui.model.auth

import com.tsci.entity.auth.Name

data class RegisterUiModel(
    val address: String,
    val email: String,
    val name: Name,
    val password: String,
    val phoneNumber: String,
    val username: String
)