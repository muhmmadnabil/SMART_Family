package com.ahmed.smartfamily.ui.member

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.smartfamily.data.model.Members
import com.ahmed.smartfamily.data.repo.Repo
import kotlinx.coroutines.launch

class MemberViewModel : ViewModel() {

    var memberListener: MemberListener? = null
    fun getMembers(token: Int) {
        memberListener!!.onStarted()
        if (memberListener!!.onConnection()) {
            viewModelScope.launch {
                val response = Repo().getMembers()
                if (response.isSuccessful) {
                    for (member in response.body()!!) {
                        if (member.token == token) {
                            val m = Members(
                                member.id,
                                member.name,
                                member.email,
                                member.token,
                                member.phone
                            )
                            memberListener!!.onSuccess(m)
                        }
                    }

                }else memberListener!!.onFailure("Member is not existed")
            }
        } else memberListener!!.onFailure("NO Internet Connection")

    }
}