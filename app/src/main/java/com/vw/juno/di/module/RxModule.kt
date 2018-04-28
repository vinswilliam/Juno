package com.vw.juno.di.module

import com.vw.juno.util.AppRxSchedulers
import com.vw.juno.util.IRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class RxModule {

    @Provides
    fun provideRxSchedulers(): IRxSchedulers = AppRxSchedulers()

    @Provides
    fun providesCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
