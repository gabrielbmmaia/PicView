package com.example.photo_list_presentation

import androidx.lifecycle.ViewModel
import com.example.photo_list_domain.repository.UnsplashImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
): ViewModel() {

    fun getImages() = repository.getAllImages()
}