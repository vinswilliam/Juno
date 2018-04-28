package com.vw.juno.ui.base

import com.vw.juno.data.pref.IDefaultPref
import com.vw.juno.data.pref.IUserSessionPref
import javax.inject.Inject


open class BaseInteractor @Inject constructor(
        val defaultPref: IDefaultPref,
        val userSessionPref: IUserSessionPref)
    : IBaseInteractor {

}