package com.hectorfortuna.orgs.data

import com.hectorfortuna.orgs.data.model.Product
import java.math.BigDecimal

class ProductDao {

    fun addProduct(product: Product){
        products.add(product)
    }

    fun searchAll():List<Product>{
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>(
            Product(name = "salada de frutas",
            description = "Laranja, maçã e uva",
            value = BigDecimal("19.83")
            )
        )
    }
}