package com.vw.juno.ui.movie.nowplaying

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout
import com.vw.juno.R
import com.vw.juno.data.network.model.MovieResult
import com.vw.juno.ui.base.BaseFragment
import com.vw.juno.ui.movie.adapter.IMovieAdapter
import com.vw.juno.ui.movie.detail.MovieDetailActivity
import com.vw.juno.util.IEndlessRVScroll
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.now_playing_fragment.*
import javax.inject.Inject


open class NowPlayingFragment: BaseFragment(), IMovieView {

    @Inject
    lateinit var presenter: IMoviePresenter<IMovieView, IMovieInteractor>

    @Inject
    lateinit var mEndlessScroll: IEndlessRVScroll

    @Inject
    lateinit var adapter: IMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.now_playing_fragment, container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        presenter.onCreate()
    }

    override fun setRecyclerView() {
        context?.let {
            now_playing_movie_rv.adapter = adapter.getAdapter()
            now_playing_movie_rv.setHasFixedSize(true)
            now_playing_movie_rv.layoutManager = GridLayoutManager(it, 2)
            mEndlessScroll.setLayoutManager(now_playing_movie_rv.layoutManager)
            now_playing_movie_rv.addOnScrollListener(mEndlessScroll.getScrollListener())
            presenter.getMovies()
            presenter.subscribeOnClickItem()
            presenter.subscribeOnRefresh()
            presenter.subscribeOnLoadMore()
        }
    }

    override fun onClickItemObs(): Observable<MovieResult> = adapter.clickMovieEvent

    override fun onRefreshObs(): Observable<Any> =
            RxSwipeRefreshLayout.refreshes(now_playing_refresh)

    override fun onLoadMore(): Observable<Int> = mEndlessScroll.loadMoreEvent

    override fun insertMovies(movies: MutableList<MovieResult>) {
        now_playing_movie_rv.post { adapter.insertMovies(movies) }
    }

    override fun hideSwipeRefresh() {
        now_playing_refresh.isRefreshing = false
    }

    override fun resetEndlessScroll() {
        mEndlessScroll.reset()
    }

    override fun openMovieDetailActivity(movieId: String) {
        context?.let {
            startActivity(MovieDetailActivity.getIntent(it, movieId))
        }
    }

    override fun resetAdapter() {
        now_playing_movie_rv.post { adapter.clearAdapter() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}