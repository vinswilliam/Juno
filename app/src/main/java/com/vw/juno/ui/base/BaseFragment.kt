package com.vw.juno.ui.base

import android.content.Context
import android.support.v4.app.Fragment


open class BaseFragment: Fragment(), IBaseView {

    private var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) baseActivity = context
    }

    override fun onErrorUnauthorizedUser() {
        baseActivity?.onErrorUnauthorizedUser()
    }

    override fun onErrorDataNotFound() {
        baseActivity?.onErrorDataNotFound()
    }

    override fun onUnknownError(errorMsg: String) {
        baseActivity?.onUnknownError(errorMsg)
    }

    override fun onTimeOut() {
        baseActivity?.onTimeOut()
    }

    override fun onNetworkError() {
        baseActivity?.onNetworkError()
    }

    override fun onConnectionError() {
        baseActivity?.onConnectionError()
    }

}