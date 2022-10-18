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
    private val mapper: RegisterMapper,
    private val repository: AuthRepository
): IRegisterUseCase {
    override suspend fun register(registerUiModel: RegisterUiModel): Flow<Result<RegisterRequestModel>>{
        val requestModel = mapper.map(input = registerUiModel)
        return repository.register(requestModel)
    }


}