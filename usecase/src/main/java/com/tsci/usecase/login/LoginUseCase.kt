package com.tsci.usecase.login

import com.tsci.data.repository.AuthRepository
import com.tsci.entity.auth.LoginRequestModel
import com.tsci.ui.model.auth.LoginUiModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 11.09.2022.
 */
class LoginUseCase @Inject constructor(
    private val repository: AuthRepository,
    private val mapper : LoginMapper
): ILoginUseCase {
    override suspend fun login(loginUiModel: LoginUiModel): Flow<Result<LoginRequestModel>> {
        val requestModel = mapper.map(loginUiModel)
        return repository.login(requestModel)
    }
}