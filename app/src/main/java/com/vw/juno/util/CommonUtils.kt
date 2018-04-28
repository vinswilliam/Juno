package com.vw.juno.util

import android.content.Context
import android.net.ConnectivityManager
import com.vw.juno.di.qualifier.ApplicationContext
import javax.inject.Inject

class CommonUtils @Inject constructor(@ApplicationContext val context: Context): ICommonUtils {

    override fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun getColorRate(rate: Float): String {
        val rateIdxs = arrayOf(6, 7, 8)
        val colors = arrayOf("#E3170A", "#CEB900", "#99D138")
        var idx = rateIdxs.size - 1
        while (idx >= 0) {
            if (rate >= rateIdxs[idx]) {
                return colors[idx]
            } else {
                idx--
            }
        }
        return colors[0]
    }

}

interface ICommonUtils {
    fun isNetworkAvailable(): Boolean
    fun getColorRate(rate: Float): String
}