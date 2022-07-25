package com.hectorfortuna.orgs.data

import com.hectorfortuna.orgs.data.model.Product

class ProductDao {

    fun addProduct(product: Product){
        products.add(product)
    }

    fun searchAll():List<Product>{
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}