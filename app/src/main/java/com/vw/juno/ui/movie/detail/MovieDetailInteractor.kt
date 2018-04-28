package com.vw.juno.ui.movie.detail

import com.vw.juno.data.network.api.IMovieService
import com.vw.juno.data.network.model.MovieDetailResult
import com.vw.juno.data.pref.IDefaultPref
import com.vw.juno.data.pref.IUserSessionPref
import com.vw.juno.ui.base.BaseInteractor
import com.vw.juno.util.MOVIE_DB_API_KEY
import io.reactivex.Observable
import javax.inject.Inject


class MovieDetailInteractor @Inject constructor(
        val movieService: IMovieService, defaultPref: IDefaultPref,
        userSessionPref: IUserSessionPref)
    : BaseInteractor(defaultPref, userSessionPref), IMovieDetailInteractor {

    override fun provideMovieDetail(movieId: String): Observable<MovieDetailResult> {
        return movieService.getMovieDetail(movieId = movieId, apiKey = MOVIE_DB_API_KEY)
    }

}