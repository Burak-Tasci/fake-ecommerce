package com.tsci.usecase.register

import com.tsci.ui.model.auth.RegisterUiModel

/**
 * Created by Burak Taşcı on 11.09.2022.
 */
interface IRegisterValidationUseCase {

    fun validate(registerUiModel: RegisterUiModel): Boolean
}