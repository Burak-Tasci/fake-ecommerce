package com.tsci.usecase.register

import com.tsci.entity.auth.RegisterRequestModel
import com.tsci.ui.model.auth.RegisterUiModel
import kotlinx.coroutines.flow.Flow

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
interface IRegisterUseCase {
    suspend fun register(registerUiModel: RegisterUiModel): Flow<Result<RegisterRequestModel>>
}