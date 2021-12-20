package com.aldanmaz.skymovie.models



import com.google.gson.annotations.SerializedName



data class Movie(
    @SerializedName("genre")
    val genre: String?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("poster")
    val poster: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("year")
    val year: String?
)

