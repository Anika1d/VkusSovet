package com.template.core.retrofit.repository

import com.template.core.model.category.MenuCoreCategory
import com.template.core.model.product.MenuCoreProduct


interface RepositoryRetrofit {
    suspend fun getCategoriesList(): MenuCoreCategory
    suspend fun getProductListByCategoriesId(menuID: String): MenuCoreProduct
}