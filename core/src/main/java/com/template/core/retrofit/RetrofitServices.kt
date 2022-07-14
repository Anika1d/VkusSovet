package com.template.core.retrofit

import com.template.core.model.category.MenuCoreCategory
import com.template.core.model.product.MenuCoreProduct
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface RetrofitServices {


    @GET("getMenu.php")
    suspend fun getCategoriesList(): MenuCoreCategory


    @GET("getSubMenu.php")
    suspend fun getProductListByCategoriesId(@Query("menuID") menuID: String): MenuCoreProduct
}