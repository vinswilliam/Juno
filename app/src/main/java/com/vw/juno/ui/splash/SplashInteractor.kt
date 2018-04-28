package com.vw.juno.ui.splash

import com.vw.juno.data.pref.IDefaultPref
import com.vw.juno.data.pref.IUserSessionPref
import com.vw.juno.ui.base.BaseInteractor
import javax.inject.Inject


class SplashInteractor @Inject constructor(
        defaultPref: IDefaultPref,
        userSessionPref: IUserSessionPref)
    : BaseInteractor(defaultPref, userSessionPref), ISplashInteractor {

}