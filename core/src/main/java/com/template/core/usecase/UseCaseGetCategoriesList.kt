package com.template.core.usecase

import com.template.core.retrofit.repository.RepositoryRetrofitImpl
import javax.inject.Inject

class UseCaseGetCategoriesList @Inject constructor(private val repositoryRetrofitImpl: RepositoryRetrofitImpl) {
    suspend operator fun invoke() =
        repositoryRetrofitImpl.getCategoriesList()
}