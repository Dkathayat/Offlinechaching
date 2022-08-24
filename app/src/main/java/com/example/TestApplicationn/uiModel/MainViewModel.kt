package com.example.TestApplicationn.uiModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.TestApplicationn.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}