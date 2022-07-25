package com.hectorfortuna.orgs.view.home.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hectorfortuna.orgs.data.ProductDao
import com.hectorfortuna.orgs.databinding.ActivityMainBinding
import com.hectorfortuna.orgs.view.adapter.ProductsAdapter
import com.hectorfortuna.orgs.view.form.FormActivity

class MainActivity : AppCompatActivity() {
    private val dao = ProductDao()
    private val adapter = ProductsAdapter(dao.searchAll())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        setFabButton()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAll())

    }

    private fun setRecyclerView(){
        binding.recyclerHome.adapter = adapter
        }

    private fun setFabButton(){
        binding.floatingActionButton.setOnClickListener{
            startActivity(Intent(this@MainActivity,FormActivity::class.java))
        }
    }
}


