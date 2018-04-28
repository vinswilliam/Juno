package com.vw.juno.ui.base

import com.vw.juno.util.IRxSchedulers
import io.reactivex.disposables.CompositeDisposable


interface IBaseView {
    fun onErrorUnauthorizedUser()
    fun onErrorDataNotFound()
    fun onUnknownError(errorMsg: String)
    fun onTimeOut()
    fun onNetworkError()
    fun onConnectionError()
}

interface IBaseInteractor {

}


interface IBasePresenter<V : IBaseView, I : IBaseInteractor> {
    val view: V
    val interactor: I
    val rxSchedulers: IRxSchedulers
    val compositeDisposable: CompositeDisposable
    fun onAttach(view: V)
    fun onDetach()
}
