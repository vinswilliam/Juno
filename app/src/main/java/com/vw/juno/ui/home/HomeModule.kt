package com.vw.juno.ui.home

import dagger.Module
import dagger.Provides


@Module
class HomeModule {
    @Provides
    fun providesHomeInteractor(interactor: HomeInteractor): IHomeInteractor = interactor

    @Provides
    fun providesHomePresenter(presenter: HomePresenter<IHomeView, IHomeInteractor>)
            : IHomePresenter<IHomeView, IHomeInteractor> = presenter
}