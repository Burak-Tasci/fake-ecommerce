package com.tsci.usecase.categories

import kotlinx.coroutines.flow.Flow

interface IGetCategoriesUseCase {
    suspend fun getCategories(): Flow<Result<List<String>>>
}