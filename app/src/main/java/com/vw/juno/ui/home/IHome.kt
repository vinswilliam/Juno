package com.vw.juno.ui.home

import com.vw.juno.ui.base.IBaseInteractor
import com.vw.juno.ui.base.IBasePresenter
import com.vw.juno.ui.base.IBaseView


interface IHomeView: IBaseView {
}

interface IHomeInteractor: IBaseInteractor {
}

interface IHomePresenter<V: IHomeView, I: IHomeInteractor>: IBasePresenter<V, I>