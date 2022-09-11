package com.tsci.usecase.register

import com.tsci.ui.model.auth.RegisterUiModel
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 11.09.2022.
 */
class RegisterValidationUseCase @Inject constructor() :
    IRegisterValidationUseCase {
    override fun validate(registerUiModel: RegisterUiModel): Boolean{
        val isEmpty = with(registerUiModel){
            return@with city.isEmpty() or email.isEmpty() or lat.isEmpty() or long.isEmpty() or
                    name.isEmpty() or (number == -1) or password.isEmpty() or phoneNumber.isEmpty() or
                    street.isEmpty() or surname.isEmpty() or username.isEmpty() or zipcode.isEmpty()
        }
        return ! isEmpty
    }
}