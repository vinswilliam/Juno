package com.vw.juno.di.module

import com.vw.juno.util.CommonUtils
import com.vw.juno.util.ICommonUtils
import dagger.Module
import dagger.Provides


@Module
class UtilModule {

    @Provides
    fun provideCommonUtils(commonUtils: CommonUtils): ICommonUtils = commonUtils
}