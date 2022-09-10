package com.tsci.usecase.register

import com.tsci.data.repository.AuthRepository
import com.tsci.entity.auth.RegisterRequestModel
import com.tsci.ui.model.auth.RegisterUiModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
class RegisterUseCase @Inject constructor(
    private val registerMapper: RegisterMapper,
    private val authRepository: AuthRepository
): IRegisterUseCase {
    override suspend fun register(registerUiModel: RegisterUiModel): Flow<Result<RegisterRequestModel>>{
        val requestModel = registerMapper.map(input = registerUiModel)
        return authRepository.register(requestModel)
    }


}