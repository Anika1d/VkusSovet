package com.template.vkussovet.data.model.category

import androidx.compose.runtime.Composable
import com.template.core.model.category.CoreCategory

data class Category(
    val image: String,
    val menuID: String,
    val name: String,
    val subMenuCount: Int
){
    companion object{
        fun toCategory(category: CoreCategory)=Category(
            image = category.image,
            menuID = category.menuID,
            name = category.name,
            subMenuCount = category.subMenuCount
        )
    }
}
