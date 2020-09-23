package com.noor.mymoviesapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieClient {
    val base_Url:String = "https://api.themoviedb.org/3/"
    val Service:ApiService


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        Service = retrofit.create(ApiService::class.java)
    }



    fun fetchMovies(page:Int, onSuccess:(movieslist:MutableList<Movie>)->Unit, onerror:()->Unit){
        Service.getPopMovies(page=page).enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                onerror.invoke()
            }
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if(response.isSuccessful){
                    onSuccess.invoke(response.body()!!.movies)
                }
                else
                {
                   onerror.invoke()
                }
            }
        })
    }

}