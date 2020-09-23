package com.noor.mymoviesapp

import com.google.gson.annotations.SerializedName


data class MoviesResponse (
    @SerializedName ("results") val movies : MutableList<Movie>,
    @SerializedName ("page") val cPage:Int,
    @SerializedName ("total page") val totPage:Int
)

