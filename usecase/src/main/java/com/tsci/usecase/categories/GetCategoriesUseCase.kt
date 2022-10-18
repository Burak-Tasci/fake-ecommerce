package com.tsci.usecase.categories

import com.tsci.data.repository.ProductRepository
import com.tsci.ui.model.category.CategoryUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: ProductRepository,
    private val mapper: CategoryMapper
) : IGetCategoriesUseCase {
    override suspend fun getCategories(): Flow<Result<List<CategoryUiModel>>> =
        repository.getCategories().map { result ->
            result.map { categoryList ->
                mapper.map(categoryList)
            }
        }
}