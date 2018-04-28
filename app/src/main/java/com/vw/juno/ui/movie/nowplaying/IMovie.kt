package com.vw.juno.ui.movie.nowplaying

import com.vw.juno.data.network.model.MovieResult
import com.vw.juno.data.network.model.MoviesResult
import com.vw.juno.ui.base.IBaseInteractor
import com.vw.juno.ui.base.IBasePresenter
import com.vw.juno.ui.base.IBaseView
import io.reactivex.Observable


interface IMovieView: IBaseView {
    fun insertMovies(movies: MutableList<MovieResult>)
    fun setRecyclerView()
    fun onClickItemObs(): Observable<MovieResult>
    fun onRefreshObs(): Observable<Any>
    fun onLoadMore(): Observable<Int>
    fun hideSwipeRefresh()
    fun resetEndlessScroll()
    fun resetAdapter()
    fun openMovieDetailActivity(movieId: String)
}

interface IMovieInteractor: IBaseInteractor {
    fun provideMovies(page: Int): Observable<MoviesResult>
}

interface IMoviePresenter<V: IMovieView, I: IMovieInteractor>
    :IBasePresenter<V, I> {
    fun getMovies(isRefresh: Boolean = false)
    fun onCreate()
    fun subscribeOnClickItem()
    fun subscribeOnRefresh()
    fun subscribeOnLoadMore()

}