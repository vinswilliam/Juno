package com.vw.juno.ui.base

import com.vw.juno.util.IRxSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


open class BasePresenter<V : IBaseView, I : IBaseInteractor>
    @Inject constructor(override val interactor: I,
                        override val rxSchedulers: IRxSchedulers,
                        override val compositeDisposable: CompositeDisposable)
    : IBasePresenter<V, I> {

    override lateinit var view: V

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
    }

}