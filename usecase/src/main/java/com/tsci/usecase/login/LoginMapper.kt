package com.tsci.usecase.login

import com.tsci.entity.auth.LoginRequestModel
import com.tsci.ui.model.auth.LoginUiModel
import com.tsci.usecase.Mapper
import javax.inject.Inject

class LoginMapper @Inject constructor() : Mapper<LoginUiModel, LoginRequestModel> {
    override fun map(input: LoginUiModel): LoginRequestModel = LoginRequestModel(
        username = input.username,
        password = input.password
    )

}
