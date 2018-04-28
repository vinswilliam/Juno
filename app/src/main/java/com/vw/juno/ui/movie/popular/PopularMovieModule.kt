package com.vw.juno.ui.movie.popular

import com.vw.juno.ui.movie.nowplaying.IMovieInteractor
import com.vw.juno.ui.movie.nowplaying.IMoviePresenter
import com.vw.juno.ui.movie.nowplaying.IMovieView
import com.vw.juno.ui.movie.nowplaying.*
import dagger.Module
import dagger.Provides


@Module
class PopularMovieModule {

    @Provides
    fun providePopularMovie(
            presenter: NowPlayingPresenter<IMovieView, IMovieInteractor>)
            : IMoviePresenter<IMovieView, IMovieInteractor> = presenter

    @Provides
    fun providePopularMovieInteractor(interactor: PopularMovieInteractor)
            : IMovieInteractor = interactor
}