package com.aldanmaz.skymovie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldanmaz.skymovie.models.Movie
import com.aldanmaz.skymovie.models.MovieResponse
import com.aldanmaz.skymovie.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel
    @Inject
    constructor (private val repository: MovieRepository): ViewModel() {

        private val _response = MutableLiveData<List<MovieResponse>>()
        val responseMovie: LiveData<List<MovieResponse>>
            get() = _response


        init {
            getAllMovies()

        }

        private fun getAllMovies() = viewModelScope.launch {
            repository.getMovies().let {  response ->

                if(response.isSuccessful) {
                    _response.postValue(response.body()?.movies)
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}")
                }
            }
        }

    }
