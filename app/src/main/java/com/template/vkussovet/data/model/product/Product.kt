package com.template.vkussovet.data.model.product

import com.template.core.model.product.CoreProduct

data class Product(
    val content: String,
    val id: String,
    val image: String,
    val name: String,
    val price: String,
    val spicy: String?,
    val weight: String
){
    companion object{
        fun toProduct(product: CoreProduct)=
            Product(
                content = product.content,
                id=product.id,
                image = product.image,
                name = product.name,
                price = product.price,
                spicy = product.spicy,
                weight = product.weight
            )
    }
}