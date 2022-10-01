package com.tsci.fake_ecommerce.di


import com.tsci.usecase.categories.GetCategoriesUseCase
import com.tsci.usecase.categories.IGetCategoriesUseCase
import com.tsci.usecase.login.ILoginUseCase
import com.tsci.usecase.login.LoginUseCase
import com.tsci.usecase.product.GetAllProductsUseCase
import com.tsci.usecase.product.IGetAllProductsUseCase
import com.tsci.usecase.register.IRegisterUseCase
import com.tsci.usecase.register.IRegisterValidationUseCase
import com.tsci.usecase.register.RegisterUseCase
import com.tsci.usecase.register.RegisterValidationUseCase
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
    abstract fun bindRegisterUseCase(impl: RegisterUseCase): IRegisterUseCase
    @Binds
    abstract fun bindRegisterValidationUseCase(impl: RegisterValidationUseCase): IRegisterValidationUseCase
    @Binds
    abstract fun bindLoginUseCase(impl: LoginUseCase): ILoginUseCase
    @Binds
    abstract fun bindGetAllProducts(impl: GetAllProductsUseCase): IGetAllProductsUseCase
    @Binds
    abstract fun bindGetCategories(impl: GetCategoriesUseCase): IGetCategoriesUseCase
}
