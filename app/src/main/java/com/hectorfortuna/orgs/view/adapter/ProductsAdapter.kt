package com.hectorfortuna.orgs.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hectorfortuna.orgs.data.model.Product
import com.hectorfortuna.orgs.databinding.ProductItemBinding

class ProductsAdapter(
    productsList: List<Product>
) : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    private val productsList = productsList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)

    }

    override fun getItemCount(): Int = productsList.count()

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bindView(productsList[position])
    }

    fun update(products: List<Product>) {
        this.productsList.clear()
        this.productsList.addAll(products)
        notifyDataSetChanged()
    }



    class ProductsViewHolder(
        private val binding: ProductItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(product: Product) {
            binding.run {
                txtName.text = product.name
                txtDescription.text = product.description
                txtValue.text = product.value.toPlainString()
            }
        }

    }
}
