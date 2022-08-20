package com.example.animefacts.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animefacts.data.SharedRepository
import com.example.animefacts.network.GetAnimeByGenreResponse
import com.example.animefacts.network.GetAnimePictureByIdResponse
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private val repository = SharedRepository()

    private val _animeGenreLiveData = MutableLiveData<GetAnimeByGenreResponse>()
    val animeGenreLiveData: LiveData<GetAnimeByGenreResponse?> = _animeGenreLiveData

    private val _animeImageLiveData = MutableLiveData<GetAnimePictureByIdResponse>()
    val animeImageLiveData: LiveData<GetAnimePictureByIdResponse?> = _animeImageLiveData

    fun refreshAimeImage(animeId: Int) {
        viewModelScope.launch {
            val imageResponse = repository.getAnimeImage(animeId)
            _animeImageLiveData.postValue(imageResponse)
        }
    }

    fun refreshAnimeGenre() {
        viewModelScope.launch {
            val response = repository.getAnimeGenre()

            _animeGenreLiveData.postValue(response)
        }
    }

}