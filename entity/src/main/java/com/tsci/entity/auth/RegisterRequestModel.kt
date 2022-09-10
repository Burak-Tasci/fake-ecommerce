package com.tsci.entity.auth

data class RegisterRequestModel(
    val address: Address?,
    val email: String?,
    val name: Name?,
    val password: String?,
    val phone: String?,
    val username: String?
)