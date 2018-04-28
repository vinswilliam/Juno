package com.vw.juno.data.pref

import com.vw.juno.data.network.model.RequestTokenResult


interface IUserSessionPref {
    fun setToken(token: RequestTokenResult)
    fun getToken(): RequestTokenResult
    fun clear()
}