package com.template.core.retrofit.repository

import com.template.core.model.category.MenuCoreCategory
import com.template.core.model.product.MenuCoreProduct
import com.template.core.retrofit.RetrofitServices
import javax.inject.Inject

class RepositoryRetrofitImpl @Inject constructor(
    private val retrofitServices: RetrofitServices
) : RepositoryRetrofit {
    override suspend fun getCategoriesList(): MenuCoreCategory =
        retrofitServices.getCategoriesList()

    override suspend fun getProductListByCategoriesId(menuID: String): MenuCoreProduct =
        retrofitServices.getProductListByCategoriesId(menuID = menuID)

}