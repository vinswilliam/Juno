package com.vw.juno.ui.movie.nowplaying

import com.vw.juno.data.network.model.ParamRequest
import com.vw.juno.ui.base.BasePresenter
import com.vw.juno.util.IRxSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class NowPlayingPresenter<V: IMovieView, I: IMovieInteractor>
@Inject constructor(interactor: I, rxSchedulers: IRxSchedulers,
                    compositeDisposable: CompositeDisposable)
    :BasePresenter<V, I> (interactor, rxSchedulers, compositeDisposable),
        IMoviePresenter<V, I> {

    @Inject
    lateinit var paramRequest: ParamRequest

    override fun onCreate() {
        view.setRecyclerView()
    }

    override fun getMovies(isRefresh: Boolean) {
        compositeDisposable.add(
                interactor.provideMovies(paramRequest.page)
                .observeOn(rxSchedulers.androidThread())
                .subscribeOn(rxSchedulers.internet())
                .subscribe({
                    if (isRefresh) {
                        view.resetAdapter()
                    }
                    ++paramRequest.page
                    view.insertMovies((it.results.toMutableList()))
                }, { view.onUnknownError(it.message ?: "") }))
    }

    override fun subscribeOnClickItem() {
        compositeDisposable.add(view.onClickItemObs()
                .observeOn(rxSchedulers.androidThread())
                .subscribe({ view.openMovieDetailActivity(it.id) }))
    }

    override fun subscribeOnRefresh() {
        compositeDisposable.add(view.onRefreshObs()
                .observeOn(rxSchedulers.androidThread())
                .subscribe {
                    view.hideSwipeRefresh()
                    view.resetEndlessScroll()
                    paramRequest.reset()
                    getMovies(true)
                })
    }

    override fun subscribeOnLoadMore() {
        compositeDisposable.add(view.onLoadMore().subscribe { getMovies() } )
    }
}