package com.vw.juno.ui.movie.toprated

import com.vw.juno.data.network.api.IMovieService
import com.vw.juno.data.network.api.MovieServiceConst
import com.vw.juno.data.network.model.MoviesResult
import com.vw.juno.data.pref.IDefaultPref
import com.vw.juno.data.pref.IUserSessionPref
import com.vw.juno.ui.base.BaseInteractor
import com.vw.juno.ui.movie.nowplaying.IMovieInteractor
import com.vw.juno.util.MOVIE_DB_API_KEY
import io.reactivex.Observable
import javax.inject.Inject


class TopRatedMovieInteractor @Inject constructor(
        defaultPref: IDefaultPref, userSessionPref: IUserSessionPref,
        val movieService: IMovieService)
    : BaseInteractor(defaultPref, userSessionPref), IMovieInteractor {

    override fun provideMovies(page: Int): Observable<MoviesResult> {
        return movieService.getMovies(category = MovieServiceConst.TOP_RATED,
                apiKey = MOVIE_DB_API_KEY, page = page)
    }

}