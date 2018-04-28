package com.vw.juno.ui.movie.detail

import com.vw.juno.data.network.model.MovieDetailResult
import com.vw.juno.ui.base.IBaseInteractor
import com.vw.juno.ui.base.IBasePresenter
import com.vw.juno.ui.base.IBaseView
import io.reactivex.Observable


interface IMovieDetailView: IBaseView {
    fun bindBackdrop(backdrop: String)
    fun bindTitle(title: String, releaseDate: String)
    fun bindPoster(poster: String)
    fun bindRate(rate: Float, participants: Int)
    fun bindOverview(overview: String)
    fun bindTagline(tagline: String)
    fun bindBudget(budget: String)
    fun bindOriginalTitle(originalTitle: String)
}

interface IMovieDetailInteractor: IBaseInteractor {
    fun provideMovieDetail(movieId: String): Observable<MovieDetailResult>
}

interface IMovieDetailPresenter<V: IMovieDetailView, I: IMovieDetailInteractor>
    : IBasePresenter<V, I> {
    fun getMovieDetail(movieId: String)
}

