package com.vw.juno.di.component

import android.app.Application
import com.vw.juno.di.builder.ActivityBuilder
import com.vw.juno.di.module.*
import com.vw.juno.root.CustomApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (NetworkModule::class),
    (ApiModule::class),
    (RxModule::class),
    (PreferenceModule::class),
    (UtilModule::class),
    (ActivityBuilder::class)])
interface ApplicationComponent {
    fun inject(app: CustomApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}