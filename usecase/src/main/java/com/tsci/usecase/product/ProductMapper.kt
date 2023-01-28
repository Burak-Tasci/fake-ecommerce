package com.tsci.usecase.product

import com.tsci.entity.product.ProductEntityModel
import com.tsci.ui.model.product.ProductUiModel
import com.tsci.usecase.Mapper
import javax.inject.Inject

/**
 * Created by Burak Taşcı on 26.09.2022.
 */
class ProductMapper @Inject constructor(): Mapper<ProductEntityModel, ProductUiModel> {
    override fun map(input: ProductEntityModel): ProductUiModel = ProductUiModel(
        id = input.id ?: -1,
        category = input.category ?: "",
        title = input.title ?: "",
        image = input.image ?: "",
        price = input.price ?:  0.0,
        ratingAverage = input.rating?.rate ?: 0.0

    )
}