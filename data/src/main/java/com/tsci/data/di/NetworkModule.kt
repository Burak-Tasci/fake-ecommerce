package com.dogancan.remote.di

import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import com.skydoves.sandwich.adapters.DataSourceCallAdapterFactory
import com.tsci.data.remote.AuthService
import com.tsci.data.remote.CartService
import com.tsci.data.remote.ProductService
import com.tsci.data.remote.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = "https://fakestoreapi.com/"

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
        .addCallAdapterFactory(DataSourceCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)
    @Provides
    @Singleton
    fun provideProductApiService(retrofit: Retrofit): ProductService =
        retrofit.create(ProductService::class.java)
    @Provides
    @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
    @Provides
    @Singleton
    fun provideCartApiService(retrofit: Retrofit): CartService =
        retrofit.create(CartService::class.java)
}
