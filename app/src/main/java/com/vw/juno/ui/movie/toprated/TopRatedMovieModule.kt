package com.vw.juno.ui.movie.toprated

import com.vw.juno.ui.movie.nowplaying.IMovieInteractor
import com.vw.juno.ui.movie.nowplaying.IMoviePresenter
import com.vw.juno.ui.movie.nowplaying.IMovieView
import com.vw.juno.ui.movie.nowplaying.*
import dagger.Module
import dagger.Provides

@Module
class TopRatedMovieModule {
    @Provides
    fun provideLatestMoviePresenter(
            presenter: NowPlayingPresenter<IMovieView, IMovieInteractor>)
            : IMoviePresenter<IMovieView, IMovieInteractor> = presenter

    @Provides
    fun provideLatestMovieInteractor(interactor: TopRatedMovieInteractor)
            : IMovieInteractor = interactor
}