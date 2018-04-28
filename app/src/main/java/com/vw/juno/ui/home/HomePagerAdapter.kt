package com.vw.juno.ui.home

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.vw.juno.R
import com.vw.juno.ui.movie.toprated.TopRatedMovieFragment
import com.vw.juno.ui.movie.nowplaying.NowPlayingFragment
import com.vw.juno.ui.movie.popular.PopularFragment


class HomePagerAdapter(val context: Context,
                       fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when(position) {
        0 -> PopularFragment()
        1 -> NowPlayingFragment()
        else -> TopRatedMovieFragment()
    }

    override fun getCount(): Int = TOTAL_ITEM

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.popular_movie)
        1 -> context.getString(R.string.now_playing_movie)
        else -> context.getString(R.string.top_rated)
    }

    companion object {
        const val TOTAL_ITEM = 3
    }
}