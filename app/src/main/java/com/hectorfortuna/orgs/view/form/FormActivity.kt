package com.hectorfortuna.orgs.view.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hectorfortuna.orgs.data.ProductDao
import com.hectorfortuna.orgs.data.model.Product
import com.hectorfortuna.orgs.databinding.ActivityFormBinding
import com.hectorfortuna.orgs.view.adapter.ProductsAdapter
import java.math.BigDecimal

class FormActivity : AppCompatActivity() {
    val dao = ProductDao()
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton.setOnClickListener {
            val name = binding.nameForm.text.toString()
            val description = binding.descriptionForm.text.toString()
            val valueString = binding.valueForm.text.toString()

            val value = if (valueString.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valueString)
            }

            val newProduct = Product(
                name = name,
                description = description,
                value = value
            )

            Log.i("FormActivity", "onCreate: $newProduct")
            dao.addProduct(newProduct)
            Log.i("FormActivity", "onCreate:${dao.searchAll()}")
        }
    }


}