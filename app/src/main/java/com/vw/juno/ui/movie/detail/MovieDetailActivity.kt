package com.vw.juno.ui.movie.detail

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vw.juno.R
import com.vw.juno.ui.base.BaseActivity
import com.vw.juno.util.ICommonUtils
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.movie_detail_activity.*
import javax.inject.Inject


class MovieDetailActivity: BaseActivity(), IMovieDetailView {

    @Inject
    lateinit var presenter: IMovieDetailPresenter<IMovieDetailView, IMovieDetailInteractor>

    @Inject
    lateinit var commonUtils: ICommonUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_activity)
        supportActionBar?.hide()
        presenter.onAttach(this)
        presenter.getMovieDetail(intent.getStringExtra(EX_MOVIE_ID))
    }

    override fun bindBackdrop(backdrop: String) {
        val options = RequestOptions().placeholder(R.color.colorAccent)
        Glide.with(this)
                .load(backdrop)
                .apply(options)
                .into(movie_detail_iv_backdrop)
    }

    override fun bindTitle(title: String, releaseDate: String) {
        movie_detail_tv_title.text = getString(R.string.movie_title_template, title, releaseDate)
    }

    override fun bindPoster(poster: String) {
        val options = RequestOptions().placeholder(R.color.colorAccent)
        Glide.with(this)
                .load(poster)
                .apply(options)
                .into(movie_detail_iv_poster)
    }

    override fun bindRate(rate: Float, participants: Int) {
        movie_detail_tv_rate.text = getString(R.string.movie_rate, rate, participants)
        movie_detail_tv_rate.setTextColor(Color.parseColor(commonUtils.getColorRate(rate)))
    }

    override fun bindOverview(overview: String) {
        movie_detail_tv_overview.text = overview
    }

    override fun bindTagline(tagline: String) {
        movie_detail_tv_tagline.text = tagline
    }

    override fun bindBudget(budget: String) {
        movie_detail_tv_budget.text = getString(R.string.budget, budget)
    }

    override fun bindOriginalTitle(originalTitle: String) {
        movie_detail_tv_original_title.text = getString(R.string.original_title, originalTitle)
    }

    companion object {
        private const val EX_MOVIE_ID = "ex_movie_id"

        fun getIntent(context: Context, movieId: String) : Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(EX_MOVIE_ID, movieId)
            return intent
        }
    }

}