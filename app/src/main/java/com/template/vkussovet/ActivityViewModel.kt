package com.template.vkussovet

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.core.usecase.UseCaseGetCategoriesList
import com.template.core.usecase.UseCaseGetProductListByCategoryId
import com.template.vkussovet.data.model.category.Category
import com.template.vkussovet.data.model.product.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel
@Inject constructor(
    private val useCaseGetCategoriesList: UseCaseGetCategoriesList,
    private val useCaseGetProductListByCategoryId: UseCaseGetProductListByCategoryId
) : ViewModel() {

    private val listCategoriesList: MutableState<List<Category>> = mutableStateOf(emptyList())

    private val listProductList: MutableState<List<Product>> = mutableStateOf(emptyList())


    private val selectedCategory: MutableState<Category?> = mutableStateOf(null)

    init {
        initCategoriesList()
    }


    fun initCategoriesList() {
        viewModelScope.launch {
            listCategoriesList.value = useCaseGetCategoriesList.invoke().menuList.map {
                Category.toCategory(it)
            }
        }
    }

//    fun observerCategoriesList(lifecycleOwner: LifecycleOwner, observer: Observer<List<Category>>) {
//        listCategoriesList.observe(lifecycleOwner, observer)
//    }
//
//
//    fun observerCategory(lifecycleOwner: LifecycleOwner, observer: Observer<Category>) {
//        selectedCategory.observe(lifecycleOwner, observer)
//    }

    fun getProductListByCategory(): MutableState<List<Product>> {
        return listProductList
    }

    fun getCategoriesList(): MutableState<List<Category>> {
        return listCategoriesList
    }

    fun getSelectedCategory(): MutableState<Category?> {
        return selectedCategory
    }

    fun changeCategory(category: Category) {
        selectedCategory.value = category
        initProductList(category)
    }


    private fun initProductList(category: Category) {
        viewModelScope.launch {
            listProductList.value =
                useCaseGetProductListByCategoryId.invoke(category.menuID).menuList.map {
                    Product.toProduct(it)
                }
        }
    }
}