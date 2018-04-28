package com.vw.juno.ui.movie

import com.vw.juno.ui.movie.adapter.IMovieAdapter
import com.vw.juno.ui.movie.adapter.MovieAdapter
import com.vw.juno.util.ICommonUtils
import dagger.Module
import dagger.Provides

@Module
class MovieModules {

    @Provides
    fun provideMoviesAdapter(commonUtil: ICommonUtils): IMovieAdapter
            = MovieAdapter(mutableListOf(), commonUtil)
}