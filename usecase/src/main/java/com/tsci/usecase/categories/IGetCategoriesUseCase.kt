package com.tsci.usecase.categories

import com.tsci.ui.model.category.CategoryUiModel
import kotlinx.coroutines.flow.Flow

interface IGetCategoriesUseCase {
    suspend fun getCategories(): Flow<Result<List<CategoryUiModel>>>
}