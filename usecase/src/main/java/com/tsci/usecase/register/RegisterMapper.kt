package com.tsci.usecase.register

import com.tsci.entity.auth.Address
import com.tsci.entity.auth.Geolocation
import com.tsci.entity.auth.RegisterRequestModel
import com.tsci.ui.model.auth.RegisterUiModel
import com.tsci.usecase.Mapper
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
class RegisterMapper @Inject constructor() : Mapper<RegisterUiModel, RegisterRequestModel> {
    override fun map(input: RegisterUiModel): RegisterRequestModel = RegisterRequestModel(
        address =  Address(
            city = "",
            geolocation = Geolocation(lat = "", long = ""),
            number = 0,
            street = "",
            zipcode = ""
        ),
        email = input.email,
        name = input.name,
        password = input.password,
        phone = input.phoneNumber,
        username = input.username
    )
}