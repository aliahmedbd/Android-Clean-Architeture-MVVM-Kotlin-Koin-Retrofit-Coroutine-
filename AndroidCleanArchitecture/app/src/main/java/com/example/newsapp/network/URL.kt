package com.example.newsapp.network

import com.example.newsapp.BuildConfig

object URL {
    const val apiKey : String = BuildConfig.API_KEY
    const val baseURL : String = BuildConfig.BASE_URL

    const val GET_NEWS = "search"
}