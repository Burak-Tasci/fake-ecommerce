package com.tsci.usecase.login

import com.tsci.entity.auth.LoginRequestModel
import com.tsci.ui.model.auth.LoginUiModel
import kotlinx.coroutines.flow.Flow

interface ILoginUseCase {
    suspend fun login(loginUiModel: LoginUiModel): Flow<Result<LoginRequestModel>>
}
