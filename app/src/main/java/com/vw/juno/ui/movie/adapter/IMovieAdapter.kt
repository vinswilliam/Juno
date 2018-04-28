package com.vw.juno.ui.movie.adapter

import android.support.v7.widget.RecyclerView
import com.vw.juno.data.network.model.MovieResult
import io.reactivex.Observable


interface IMovieAdapter {
    val clickMovieEvent: Observable<MovieResult>
    fun clearAdapter()
    fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>
    fun insertMovies(movies: List<MovieResult>)
}