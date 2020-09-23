package com.noor.mymoviesapp


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id :Long,
    @SerializedName("title") val Name :String,
    @SerializedName("overview") val overView :String,
    @SerializedName("poster_path") val posterPath :String,
    @SerializedName("vote_average") val rate :String,
    @SerializedName("release_date") val year :String
)

