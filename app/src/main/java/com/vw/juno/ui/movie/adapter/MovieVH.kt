package com.vw.juno.ui.movie.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vw.juno.R
import com.vw.juno.data.network.model.MovieResult
import com.vw.juno.util.ICommonUtils
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.row_movie.view.*


class MovieVH(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(movie: MovieResult, publishSubject: PublishSubject<MovieResult>, commonUtils: ICommonUtils) {
        val options = RequestOptions()
                .placeholder(R.color.colorAccent)
        Glide.with(itemView.context)
                .load(movie.posterPathImg)
                .apply(options)
                .into(itemView.movie_iv_poster)
        itemView.movie_tv_vote_avg.text =
                itemView.context.getString(R.string.movie_rate, movie.voteAverage, movie.voteCount)
        itemView.movie_tv_title.text = itemView.context.getString(
                R.string.movie_title_template, movie.title, movie.releaseYearDate)
        itemView.movie_tv_title.ellipsize = TextUtils.TruncateAt.END
        itemView.movie_tv_overview.text = movie.overview
        itemView.movie_tv_vote_avg.setTextColor(Color.parseColor(
                commonUtils.getColorRate(movie.voteAverage)))
        itemView.setOnClickListener {
            publishSubject.onNext(movie)
        }
    }

}