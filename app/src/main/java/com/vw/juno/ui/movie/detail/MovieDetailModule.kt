package com.vw.juno.ui.movie.detail

import dagger.Module
import dagger.Provides


@Module
class MovieDetailModule {

    @Provides
    fun providesMovieDetailInteractor(interactor: MovieDetailInteractor)
            : IMovieDetailInteractor = interactor

    @Provides
    fun providesMovieDetailPresenter(presenter: MovieDetailPresenter<IMovieDetailView, IMovieDetailInteractor>)
        : IMovieDetailPresenter<IMovieDetailView, IMovieDetailInteractor> = presenter
}