package com.example.TestApplicationn.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.TestApplicationn.adapter.RecylerAdapater
import com.example.TestApplicationn.databinding.ActivityMainBinding
import com.example.TestApplicationn.uiModel.MainViewModel
import com.example.TestApplicationn.utilities.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var resturantAdapter: RecylerAdapater
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resturantAdapter = RecylerAdapater()

        binding.mainRecylerView.apply {
            adapter = resturantAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.restaurants.observe(this) { resturant ->
            resturantAdapter.submitList(resturant.data)
            binding.mainProgressBar.isVisible = resturant is Resource.Loading<*> && resturant.data.isNullOrEmpty()


        }

    }
}