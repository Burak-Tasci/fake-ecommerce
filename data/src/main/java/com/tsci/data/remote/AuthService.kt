package com.tsci.data.remote

import com.skydoves.sandwich.ApiResponse
import com.tsci.entity.auth.LoginRequestModel
import com.tsci.entity.auth.RegisterRequestModel
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Burak Taşcı on 10.09.2022.
 */
interface AuthService {

    @POST(REGISTER)
    suspend fun register(@Body requestModel: RegisterRequestModel): ApiResponse<RegisterRequestModel>

    @POST(LOGIN)
    suspend fun login(@Body requestModel: LoginRequestModel): ApiResponse<LoginRequestModel>

    companion object{
        private const val REGISTER = "users"
        private const val LOGIN = "auth/login"
    }
}