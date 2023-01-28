package com.tsci.usecase.product

import com.tsci.entity.product.ProductEntityModel
import com.tsci.ui.model.product.ProductUiModel
import com.tsci.usecase.Mapper
import javax.inject.Inject


/**
 * Created by Burak Taşcı on 29.09.2022.
 */
class ProductListMapper @Inject constructor(
    private val  productMapper: ProductMapper
): Mapper<List<ProductEntityModel>, List<ProductUiModel>> {
    override fun map(input: List<ProductEntityModel>): List<ProductUiModel> = input.map {
        productMapper.map(it)
    }


}