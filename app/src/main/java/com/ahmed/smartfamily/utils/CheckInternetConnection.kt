package com.ahmed.smartfamily.utils

import android.content.Context
import android.net.ConnectivityManager

class CheckInternetConnection(private val requireContext: Context) {
    fun isConnection(): Boolean {
        val conn =
            requireContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (conn != null) {
            val info = conn.activeNetworkInfo
            return info != null && info.isConnected
        }
        return false
    }
}