package com.template.core.usecase

import com.template.core.retrofit.repository.RepositoryRetrofitImpl
import javax.inject.Inject

class UseCaseGetProductListByCategoryId @Inject constructor(private val repositoryRetrofitImpl: RepositoryRetrofitImpl) {
    suspend operator fun invoke(menuID: String) =
        repositoryRetrofitImpl.getProductListByCategoriesId(menuID = menuID)
}