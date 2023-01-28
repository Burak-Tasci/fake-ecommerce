package com.tsci.data.repository

import com.tsci.core.base.network.BaseRepository
import com.tsci.data.di.IoDispatcher
import com.tsci.data.remote.AuthService
import com.tsci.entity.auth.LoginRequestModel
import com.tsci.entity.auth.RegisterRequestModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
class AuthRepository @Inject constructor(
    private val authService: AuthService,
    @IoDispatcher private val ioScope: CoroutineDispatcher
): BaseRepository() {

    suspend fun register(requestModel: RegisterRequestModel) = invoke {
        authService.register(requestModel)
    }.flowOn(ioScope)

    suspend fun login(requestModel: LoginRequestModel) = invoke {
        authService.login(requestModel)
    }.flowOn(ioScope)
}