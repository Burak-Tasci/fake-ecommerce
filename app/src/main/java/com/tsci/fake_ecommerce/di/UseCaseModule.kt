package com.tsci.fake_ecommerce.di


import com.tsci.usecase.register.IRegisterUseCase
import com.tsci.usecase.register.RegisterUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * @author dogancankilic
 * Created on 8.08.2022
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindRegisterUseCase(impl: IRegisterUseCase): RegisterUseCase

}
