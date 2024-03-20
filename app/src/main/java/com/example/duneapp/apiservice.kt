package com.example.duneapp



import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("v2/top-headlines")
    fun getMovie(
        @Query("title")
        title:String = "",

        @Query("apiKey")
        apiKey: String = "f957522a5caf454a98125f92856e3008"
    ): Call<Movie>
}