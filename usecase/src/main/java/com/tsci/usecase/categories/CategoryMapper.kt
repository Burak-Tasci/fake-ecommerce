package com.tsci.usecase.categories

import com.tsci.ui.model.category.CategoryUiModel
import com.tsci.usecase.Mapper
import javax.inject.Inject

class CategoryMapper @Inject constructor(): Mapper<List<String>, List<CategoryUiModel>> {
    override fun map(input: List<String>): List<CategoryUiModel> = input.map{
        CategoryUiModel(category = it, checked = false)
    }
}