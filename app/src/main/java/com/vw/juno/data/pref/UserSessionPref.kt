package com.vw.juno.data.pref

import android.content.Context
import android.content.SharedPreferences
import com.vw.juno.data.network.model.RequestTokenResult
import com.vw.juno.di.qualifier.ApplicationContext
import javax.inject.Inject


class UserSessionPref @Inject constructor(
        @ApplicationContext val context: Context,
        val prefs: SharedPreferences) : IUserSessionPref {

    override fun clear() {
        prefs.edit().clear().apply()
    }

    override fun setToken(token: RequestTokenResult) {
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putBoolean(TokenConst.SUCCESS, token.success)
        editor.putString(TokenConst.EXPIRES_AT, token.expiresAt)
        editor.putString(TokenConst.REQUEST_TOKEN, token.requestToken)
        editor.apply()
    }

    override fun getToken(): RequestTokenResult =
            RequestTokenResult(prefs.getBoolean(TokenConst.SUCCESS, false),
                    prefs.getString(TokenConst.EXPIRES_AT, ""),
                    prefs.getString(TokenConst.REQUEST_TOKEN, ""))
}