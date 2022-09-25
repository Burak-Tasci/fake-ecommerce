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
    private val authRepository: AuthRepository,
    private val loginMapper : LoginMapper
): ILoginUseCase {
    override suspend fun login(loginUiModel: LoginUiModel): Flow<Result<LoginRequestModel>> {
        val requestModel = loginMapper.map(loginUiModel)
        return authRepository.login(requestModel)
    }
}