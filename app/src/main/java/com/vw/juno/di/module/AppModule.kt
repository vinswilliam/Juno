package com.vw.juno.di.module

import android.app.Application
import android.content.Context
import com.vw.juno.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: Application): Context {
        return application
    }

}
