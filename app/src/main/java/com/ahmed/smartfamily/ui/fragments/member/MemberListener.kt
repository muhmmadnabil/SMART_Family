package com.ahmed.smartfamily.ui.fragments.member

import com.ahmed.smartfamily.data.model.Members

interface MemberListener {
    fun onStarted()
    fun onSuccess(member: Members)
    fun onFailure(msg: String)
    fun onConnection(): Boolean
}