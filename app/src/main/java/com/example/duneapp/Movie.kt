package com.example.duneapp

import android.widget.ImageView
import java.io.Serializable

data class News(
    val title: String,
    val year: Int,
    val poster: ImageView
)