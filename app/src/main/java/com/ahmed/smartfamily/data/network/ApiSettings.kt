package com.ahmed.smartfamily.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiSettings {

    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl("https://alm143.github.io/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiInstance: SmartApi by lazy {
        retrofit.create(SmartApi::class.java)
    }
}