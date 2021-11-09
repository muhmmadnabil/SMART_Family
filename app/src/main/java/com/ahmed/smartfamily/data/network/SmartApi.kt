package com.ahmed.smartfamily.data.network

import com.ahmed.smartfamily.data.model.Members
import retrofit2.Response
import retrofit2.http.GET

interface SmartApi {

    @GET("data.json")
    suspend fun getMembers(): Response<List<Members>>
}