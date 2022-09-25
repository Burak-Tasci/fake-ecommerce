package com.tsci.usecase.register

import com.tsci.entity.auth.Address
import com.tsci.entity.auth.Geolocation
import com.tsci.entity.auth.Name
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
            city = input.city,
            geolocation = Geolocation(lat = input.lat, long = input.long),
            number = input.number,
            street = input.street,
            zipcode = input.zipcode
        ),
        email = input.email,
        name = Name(input.name, input.surname),
        password = input.password,
        phone = input.phoneNumber,
        username = input.username
    )
}