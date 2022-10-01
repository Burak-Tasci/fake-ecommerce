package com.tsci.usecase.categories

import com.tsci.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: ProductRepository
): IGetCategoriesUseCase {
    override suspend fun getCategories(): Flow<Result<List<String>>> = repository.getCategories()
}