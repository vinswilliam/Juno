package com.vw.juno.ui.movie.popular

import com.vw.juno.di.module.ApiModule
import com.vw.juno.di.module.NetworkModule
import com.vw.juno.di.module.RecyclerViewModule
import com.vw.juno.ui.movie.MovieModules
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class PopularMovieProvider {
    @ContributesAndroidInjector(modules = [
        (PopularMovieModule::class),
        (NetworkModule::class),
        (ApiModule::class),
        (MovieModules::class),
        (RecyclerViewModule::class)])
    abstract fun providePopularMovieFragment(): PopularFragment

}