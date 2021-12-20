package com.aldanmaz.skymovie.repository

import com.aldanmaz.skymovie.services.MovieApiInterface
import javax.inject.Inject

class MovieRepository
@Inject
constructor(private val apiService: MovieApiInterface){


     suspend fun getMovies() = apiService.getMovieList()
}