package com.example.dogimage.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogimage.DogImage
import com.example.dogimage.network.DogImageApiService.DogImageApi.retrofitService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _currentlyDisplayedImage = MutableLiveData<DogImage>()
    val currentlyDisplayedImage: LiveData<DogImage> = _currentlyDisplayedImage

    init {
        getNewDog()
    }

    fun getNewDog() {
        viewModelScope.launch {
            _currentlyDisplayedImage.value = retrofitService.getRandomDogImage()
        }
    }
}