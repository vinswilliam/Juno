package com.vw.juno.ui.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vw.juno.R

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

    override fun onErrorUnauthorizedUser() {
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.unauthorized_user),
                Snackbar.LENGTH_SHORT).show()
    }

    override fun onErrorDataNotFound() {
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.data_not_found),
                Snackbar.LENGTH_SHORT).show()
    }

    override fun onUnknownError(errorMsg: String) {
        Snackbar.make(findViewById(android.R.id.content), errorMsg, Snackbar.LENGTH_SHORT).show()
    }

    override fun onTimeOut() {
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.request_time_out),
                Snackbar.LENGTH_SHORT).show()
    }

    override fun onNetworkError() {
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.network_error),
                Snackbar.LENGTH_SHORT).show()
    }

    override fun onConnectionError() {
        Snackbar.make(findViewById(android.R.id.content), getString(R.string.connection_error),
                Snackbar.LENGTH_SHORT).show()
    }
}