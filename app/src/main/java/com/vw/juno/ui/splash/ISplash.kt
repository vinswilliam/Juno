package com.vw.juno.ui.splash

import com.vw.juno.ui.base.IBaseInteractor
import com.vw.juno.ui.base.IBasePresenter
import com.vw.juno.ui.base.IBaseView


interface ISplashView : IBaseView {

}

interface ISplashInteractor : IBaseInteractor {

}

interface ISplashPresenter<V : ISplashView, I : ISplashInteractor> : IBasePresenter<V, I> {

    fun onCreate()
}