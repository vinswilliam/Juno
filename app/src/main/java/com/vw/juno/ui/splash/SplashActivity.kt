package com.vw.juno.ui.splash

import android.os.Bundle
import com.vw.juno.R
import com.vw.juno.ui.base.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : BaseActivity(), ISplashView {

    @Inject
    lateinit var presenter: ISplashPresenter<ISplashView, ISplashInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.onAttach(this)
        presenter.onCreate()
    }
}
