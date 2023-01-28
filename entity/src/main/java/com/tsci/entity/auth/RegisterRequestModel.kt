package com.tsci.entity.auth

data class RegisterRequestModel(
    val address: Address?,
    val email: String?,
    val name: Name?,
    val password: String?,
    val phone: String?,
    val username: String?
)

data class Name(
    val firstname: String?,
    val lastname: String?
)

data class Geolocation(
    val lat: String?,
    val long: String?
)
data class Address(
    val city: String?,
    val geolocation: Geolocation?,
    val number: Int?,
    val street: String?,
    val zipcode: String?
)