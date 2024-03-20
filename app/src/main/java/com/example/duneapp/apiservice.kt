package com.example.duneapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/")
    fun getMovie(
        @Query("t") title: String,
        @Query("apiKey") apiKey: String
    ): Call<Movie>
}
