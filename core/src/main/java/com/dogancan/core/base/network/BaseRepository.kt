package com.dogancan.core.base.network

import com.skydoves.sandwich.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by dogancan.kilic on 4/20/2022.
 */
abstract class BaseRepository {

    fun <T> invoke(
        call: suspend () -> ApiResponse<T>,
    ): Flow<Result<T>> = flow {
        val response = call.invoke()
        response.suspendOnSuccess {
            emit(Result.success(this.data))
        }.suspendOnError {
            val message = this.errorBody?.string() ?: this.message()
            emit(Result.failure(Throwable(message)))
        }.suspendOnException {
            emit(Result.failure(Throwable(message)))
        }
    }
}
