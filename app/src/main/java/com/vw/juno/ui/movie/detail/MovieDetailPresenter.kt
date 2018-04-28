package com.vw.juno.ui.movie.detail

import com.vw.juno.ui.base.BasePresenter
import com.vw.juno.util.IRxSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MovieDetailPresenter<V: IMovieDetailView, I: IMovieDetailInteractor>
@Inject constructor(interactor: I, rxSchedulers: IRxSchedulers,
                    compositeDisposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, rxSchedulers, compositeDisposable),
        IMovieDetailPresenter<V, I> {

    override fun getMovieDetail(movieId: String) {
        compositeDisposable.add(interactor.provideMovieDetail(movieId)
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe({
                    view.bindBackdrop(it.backdropPathImg)
                    view.bindTitle(it.title, it.releaseYearDate)
                    view.bindPoster(it.posterPathImg)
                    view.bindRate(it.voteAverage, it.voteCount)
                    view.bindOverview(it.overview)
                    view.bindOriginalTitle(it.originalTitle)
                    view.bindTagline(it.tagline)
                    view.bindBudget(it.budgetString)
                }, { view.onUnknownError(it.message ?: "") }))
    }

}