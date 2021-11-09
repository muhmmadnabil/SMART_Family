package com.ahmed.smartfamily.data.repo

import com.ahmed.smartfamily.data.model.Members
import com.ahmed.smartfamily.data.network.ApiSettings
import retrofit2.Response

class Repo {
    suspend fun getMembers(): Response<List<Members>> = ApiSettings.apiInstance.getMembers()
}