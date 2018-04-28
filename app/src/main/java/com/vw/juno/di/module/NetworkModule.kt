package com.vw.juno.di.module

import android.content.Context
import com.vw.juno.BuildConfig
import com.vw.juno.data.network.toolbox.OfflineResponseCacheInterceptor
import com.vw.juno.data.network.toolbox.ResponseCacheInterceptor
import com.vw.juno.di.qualifier.ApplicationContext
import com.vw.juno.util.AppRxSchedulers
import com.vw.juno.util.CommonUtils
import com.vw.juno.util.ICommonUtils
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Named


@Module
class NetworkModule {

    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    fun provideCache(file: File): Cache = Cache(file, MAX_CACHE.toLong())

    @Provides
    fun provideCacheFile(@ApplicationContext context: Context): File = context.filesDir

    @Provides
    fun provideRxAdapter(): RxJava2CallAdapterFactory =
            RxJava2CallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS)

    @Provides
    fun provideGsonClient(): GsonConverterFactory = GsonConverterFactory.create()


    @Provides
    @Named(BASE_URL)
    fun provideBaseUrl(): String = "https://api.themoviedb.org/"

    @Provides
    fun provideOkHttpClientApi(logger: HttpLoggingInterceptor,
                               commonUtils: ICommonUtils): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(logger)
            builder.addNetworkInterceptor(logger)
        }
//        builder.cache(cache)
//        builder.authenticator(TokenAuthenticator(mContext))
//        builder.addInterceptor(APIInterceptor(mContext))
        builder.addNetworkInterceptor(ResponseCacheInterceptor())
        builder.addInterceptor(OfflineResponseCacheInterceptor(commonUtils))
        builder.retryOnConnectionFailure(true)
        return builder.build()
    }

    @Provides
    fun provideRetrofitApi(
            client: OkHttpClient,
            gson: GsonConverterFactory,
            rxAdapter: RxJava2CallAdapterFactory,
            @Named(BASE_URL) url: String): Retrofit =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(url)
                    .addConverterFactory(gson).addCallAdapterFactory(rxAdapter).build()

    companion object {
        const val MAX_CACHE = 100000
        const val BASE_URL = "base_url"
    }
}