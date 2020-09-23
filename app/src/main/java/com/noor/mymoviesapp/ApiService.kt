package com.noor.mymoviesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopMovies(@Query("api_key")apiKey:String="ad61d2e15d680e25b0cb5e1449b90658",
                     @Query("page")page:Int): Call<MoviesResponse>

}