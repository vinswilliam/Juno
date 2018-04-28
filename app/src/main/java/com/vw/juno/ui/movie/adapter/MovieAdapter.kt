package com.vw.juno.ui.movie.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vw.juno.R
import com.vw.juno.data.network.model.MovieResult
import com.vw.juno.util.ICommonUtils
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


class MovieAdapter @Inject constructor(var movies: MutableList<MovieResult>,
                                       val commonUtil: ICommonUtils)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), IMovieAdapter {

    private val clickMovieSubject = PublishSubject.create<MovieResult>()

    override val clickMovieEvent: Observable<MovieResult>
        get() = clickMovieSubject

    override fun clearAdapter() {
        movies.clear()
        notifyDataSetChanged()
    }

    override fun getAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> = this

    override fun insertMovies(movies: List<MovieResult>) {
        val currTotal = itemCount
        this.movies.addAll(movies)
        notifyItemRangeInserted(currTotal, this.movies.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_movie, parent, false)
        return MovieVH(v)
    }

    override fun getItemCount(): Int = this.movies.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = holder as MovieVH
        movieViewHolder.bind(movies[position], clickMovieSubject, commonUtil)
    }

}