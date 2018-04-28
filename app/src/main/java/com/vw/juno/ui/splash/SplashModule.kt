package com.vw.juno.ui.splash

import dagger.Module
import dagger.Provides


@Module
class SplashModule {

    @Provides
    fun proidesSplashPresenter(presenter: SplashPresenter<ISplashView, ISplashInteractor>)
        : ISplashPresenter<ISplashView, ISplashInteractor> = presenter

    @Provides
    fun providesSplashInteractor(interactor: SplashInteractor) : ISplashInteractor = interactor
}