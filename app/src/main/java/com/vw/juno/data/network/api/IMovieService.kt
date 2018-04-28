package com.vw.juno.data.network.api

import com.vw.juno.data.network.model.MovieDetailResult
import com.vw.juno.data.network.model.MoviesResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface IMovieService {
    @GET("3/movie/{category}")
    fun getMovies(@Path("category") category: String,
                   @Query("api_key") apiKey: String,
                   @Query("language") language: String = "en-US",
                   @Query("page") page: Int? = 1,
                   @Query("region") region: String? = null)
    : Observable<MoviesResult>

    @GET("3/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: String,
                       @Query("api_key") apiKey: String,
                       @Query("language") language: String = "en-US",
                       @Query("append_to_response") appendToResponse: String? = null)
    : Observable<MovieDetailResult>
}

class MovieServiceConst{
    companion object {
        const val NOW_PLAYING = "now_playing"
        const val POPULAR = "popular"
        const val TOP_RATED = "top_rated"
    }
}