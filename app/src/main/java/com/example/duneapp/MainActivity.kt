package com.example.duneapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTitle = findViewById<EditText>(R.id.inputtitle)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val movieTitleView = findViewById<TextView>(R.id.movietitle)
        val movieYearView = findViewById<TextView>(R.id.movieyear)
        val moviePosterView = findViewById<ImageView>(R.id.movieposter)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)

        submitBtn.setOnClickListener {
            val movieTitle = inputTitle.text.toString()
            apiService.getMovie(title = movieTitle, apiKey = "ebb1677b").enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        val movie = response.body()
                        movie?.let {
                            movieTitleView.text = it.title
                            movieYearView.text = it.year
                            moviePosterView.load(it.poster) {
                                crossfade(true)
                            }
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "Failed to fetch movie details", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}
