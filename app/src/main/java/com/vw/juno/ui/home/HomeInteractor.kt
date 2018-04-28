package com.vw.juno.ui.home

import com.vw.juno.data.pref.IDefaultPref
import com.vw.juno.data.pref.IUserSessionPref
import com.vw.juno.ui.base.BaseInteractor
import javax.inject.Inject


class HomeInteractor @Inject constructor(
        defaultPref: IDefaultPref, userSessionPref: IUserSessionPref)
    : BaseInteractor(defaultPref, userSessionPref), IHomeInteractor {

}