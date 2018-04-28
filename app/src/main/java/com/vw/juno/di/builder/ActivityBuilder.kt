package com.vw.juno.di.builder

import com.vw.juno.ui.home.HomeActivity
import com.vw.juno.ui.home.HomeModule
import com.vw.juno.ui.movie.detail.MovieDetailActivity
import com.vw.juno.ui.movie.detail.MovieDetailModule
import com.vw.juno.ui.movie.toprated.TopRatedMovieProvider
import com.vw.juno.ui.movie.nowplaying.NowPlayingProvider
import com.vw.juno.ui.movie.popular.PopularMovieProvider
import com.vw.juno.ui.splash.SplashActivity
import com.vw.juno.ui.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(SplashModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(HomeModule::class), (NowPlayingProvider::class),
        TopRatedMovieProvider::class, PopularMovieProvider::class])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    abstract fun bindMovieDetailModule(): MovieDetailActivity
}