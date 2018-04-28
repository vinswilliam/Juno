package com.vw.juno.ui.splash

import com.vw.juno.ui.base.BasePresenter
import com.vw.juno.util.IRxSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class SplashPresenter<V : ISplashView, I : ISplashInteractor> @Inject constructor(
        interactor : I, compositeDisposable : CompositeDisposable, rxSchedulers : IRxSchedulers)
    : BasePresenter<V, I>(interactor, rxSchedulers, compositeDisposable), ISplashPresenter<V, I> {

    override fun onCreate() {
    }

}