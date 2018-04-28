package com.vw.juno.data.network.api

import com.vw.juno.data.network.model.ConfigurationResult
import com.vw.juno.data.network.model.CountryResult
import com.vw.juno.data.network.model.LanguageResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface IConfigurationApi {
    @GET("3/configuration")
    fun getConfiguration(@Query("api_key") apiKey: String): Observable<ConfigurationResult>

    @GET("3/configuration/countries")
    fun getCountries(@Query("api_key") apiKey: String): Observable<Array<CountryResult>>

    @GET("3/configuration/languages")
    fun getLanguages(@Query("api_key") apiKey: String): Observable<Array<LanguageResult>>
}