package com.example.duneapp



import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("/")
    fun getMovie(
        @Query("t") t:String,

        @Query("apiKey") apiKey: String = "ebb1677b"
    ): Call<Movie>
}