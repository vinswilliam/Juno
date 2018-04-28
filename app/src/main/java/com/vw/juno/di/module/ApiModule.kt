package com.vw.juno.di.module

import com.vw.juno.data.network.api.IConfigurationApi
import com.vw.juno.data.network.api.IMovieService
import com.vw.juno.data.network.api.IUserAuth
import com.vw.juno.data.network.model.ParamRequest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class ApiModule {

    @Provides
    fun provideUserAuth(retrofit: Retrofit): IUserAuth = retrofit.create(IUserAuth::class.java)

    @Provides
    fun providesConfigurationApi(retrofit: Retrofit): IConfigurationApi
            = retrofit.create(IConfigurationApi::class.java)

    @Provides
    fun providesMovie(retrofit: Retrofit): IMovieService
            = retrofit.create(IMovieService::class.java)

    @Provides
    fun providesParamRequest(): ParamRequest = ParamRequest()
}