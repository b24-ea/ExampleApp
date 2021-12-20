package com.aldanmaz.skymovie.models




import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("movies")
    val movies: List<MovieResponse>
    )



