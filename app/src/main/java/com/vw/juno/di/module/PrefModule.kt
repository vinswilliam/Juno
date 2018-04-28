package com.vw.juno.di.module

import android.content.Context
import com.vw.juno.data.pref.DefaultPref
import com.vw.juno.data.pref.IDefaultPref
import com.vw.juno.data.pref.IUserSessionPref
import com.vw.juno.data.pref.UserSessionPref
import com.vw.juno.di.qualifier.ApplicationContext
import com.vw.juno.util.USER_PREFS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PreferenceModule {

    @Singleton
    @Provides
    fun provideConsumerSessionPref(@ApplicationContext context: Context)
            : IUserSessionPref = UserSessionPref(context,
            context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE))

    @Singleton
    @Provides
    fun provideDefaultSessionPref(@ApplicationContext context: Context)
            : IDefaultPref = DefaultPref(context)
}