package com.vw.juno.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors


class AppRxSchedulers: IRxSchedulers {
    override fun runOnBackground(): Scheduler = BACKGROUND_SCHEDULERS

    override fun io(): Scheduler = Schedulers.io()

    override fun compute(): Scheduler = Schedulers.computation()

    override fun androidThread(): Scheduler = AndroidSchedulers.mainThread()

    override fun internet(): Scheduler = INTERNET_SCHEDULERS

    companion object {
        private val BACKGROUND_EXECUTOR = Executors.newCachedThreadPool()
        private val BACKGROUND_SCHEDULERS = Schedulers.from(BACKGROUND_EXECUTOR)
        private val INTERNET_EXECUTOR = Executors.newCachedThreadPool()
        val INTERNET_SCHEDULERS = Schedulers.from(INTERNET_EXECUTOR)
    }
}

interface IRxSchedulers {
    fun runOnBackground(): Scheduler
    fun io(): Scheduler
    fun compute(): Scheduler
    fun androidThread(): Scheduler
    fun internet(): Scheduler
}