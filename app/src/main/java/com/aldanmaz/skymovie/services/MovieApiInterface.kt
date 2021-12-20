package com.aldanmaz.skymovie.services


import com.aldanmaz.skymovie.models.MovieResponse
import com.aldanmaz.skymovie.util.Constants
import retrofit2.Response
import retrofit2.http.GET


interface MovieApiInterface {

    @GET(Constants.END_PNT)
    suspend fun getMovieList(): Response<MovieResponse>
}