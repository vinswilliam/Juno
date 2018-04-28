package com.vw.juno.di.module

import com.vw.juno.util.*
import dagger.Module
import dagger.Provides


@Module
class RecyclerViewModule {

    @Provides
    fun providesEndlessScroll(): IEndlessRVScroll = EndlessScrollRV(VISIBLE_THRESHOLD)

}