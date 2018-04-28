package com.vw.juno.data.network.api

import com.vw.juno.data.network.model.RequestTokenResult
import com.vw.juno.data.network.model.SessionResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface IUserAuth {

    @GET("3/authentication/token/new")
    fun requestToken(@Query("api_key") apiKey: String): Observable<RequestTokenResult>

    @GET("3/authentication/session/new")
    fun createSession(@Query("api_key") apiKey: String,
                      @Query("request_token") requestToken: String)
            : Observable<SessionResult>
}