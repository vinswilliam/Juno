package com.vw.juno.ui.home

import com.vw.juno.ui.base.BasePresenter
import com.vw.juno.util.IRxSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class HomePresenter<V: IHomeView, I: IHomeInteractor>
@Inject constructor(interactor: I, rxSchedulers: IRxSchedulers,
                    compositeDisposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, rxSchedulers, compositeDisposable), IHomePresenter<V, I>