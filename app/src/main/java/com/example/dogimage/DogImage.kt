package com.example.dogimage

import com.squareup.moshi.Json

data class DogImage (@Json(name = "message") val imgSrcUrl: String)