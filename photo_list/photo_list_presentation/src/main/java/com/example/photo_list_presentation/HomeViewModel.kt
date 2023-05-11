package com.example.photo_list_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.repository.UnsplashImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
) : ViewModel() {

    val photoList: Flow<PagingData<UnsplashImage>> = repository.getAllImages().cachedIn(viewModelScope)
}