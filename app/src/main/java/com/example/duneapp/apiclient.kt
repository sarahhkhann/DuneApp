package com.example.duneapp


import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://www.omdbapi.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}

object APIClient {
    val apiService: APIService by lazy {
        RetrofitClient.retrofit.create(APIService::class.java)
    }
}