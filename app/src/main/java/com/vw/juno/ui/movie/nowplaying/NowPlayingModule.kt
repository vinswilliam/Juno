package com.vw.juno.ui.movie.nowplaying

import dagger.Module
import dagger.Provides

@Module
class NowPlayingModule {

    @Provides
    fun provideNowPlayingPresenter(
            presenter: NowPlayingPresenter<IMovieView, IMovieInteractor>)
    : IMoviePresenter<IMovieView, IMovieInteractor> = presenter

    @Provides
    fun provideNowPlayingInteractor(interactor: NowPlayingInteractor)
            : IMovieInteractor = interactor
}