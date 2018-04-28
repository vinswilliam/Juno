package com.vw.juno.util

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class EndlessScrollRV constructor(var visibleThreshold: Int = THRESHOLD)
    : RecyclerView.OnScrollListener(), IEndlessRVScroll {

    lateinit var mLayoutManager: RecyclerView.LayoutManager
    private var currentPage = 0
    private var previousTotalItemCount = 0
    private var loading = true
    private var startingPageIndex = 0
    private val loadMoreSubject = PublishSubject.create<Int>()

    override val loadMoreEvent: Observable<Int> = loadMoreSubject

    override fun setLayoutManager(layoutManager: RecyclerView.LayoutManager) {
        mLayoutManager = layoutManager
        when (mLayoutManager) {
            is GridLayoutManager ->
                visibleThreshold *= (mLayoutManager as GridLayoutManager).spanCount
            is StaggeredGridLayoutManager ->
                visibleThreshold *= (mLayoutManager as StaggeredGridLayoutManager).spanCount
        }
    }

    override fun onScrolled(view: RecyclerView?, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.itemCount

        when (mLayoutManager) {
            is StaggeredGridLayoutManager ->
                lastVisibleItemPosition = getLastVisibleItemInStagger(
                        (mLayoutManager as StaggeredGridLayoutManager)
                                .findLastVisibleItemPositions(null))
            is LinearLayoutManager -> lastVisibleItemPosition =
                    (mLayoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            is GridLayoutManager -> lastVisibleItemPosition =
                    (mLayoutManager as GridLayoutManager).findLastVisibleItemPosition()
        }

        if (totalItemCount < previousTotalItemCount) {
            this.currentPage = this.startingPageIndex
            this.previousTotalItemCount = totalItemCount
            if (totalItemCount == 0) {
                this.loading = true
            }
        }

        if (loading && totalItemCount > previousTotalItemCount) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && lastVisibleItemPosition + visibleThreshold > totalItemCount) {
            currentPage++
            loadMoreSubject.onNext(totalItemCount)
            loading = true
        }
    }

    private fun getLastVisibleItemInStagger(lastVisibleItemPositions: IntArray): Int {
        var maxSize = 0
        for (i in lastVisibleItemPositions.indices) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i]
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i]
            }
        }
        return maxSize
    }

    override fun reset() {
        currentPage = 0
        previousTotalItemCount = 0
        loading = true
        startingPageIndex = 0
    }

    override fun getScrollListener(): RecyclerView.OnScrollListener = this

    companion object {
        const val THRESHOLD = 12
    }
}

interface IEndlessRVScroll {
    fun getScrollListener(): RecyclerView.OnScrollListener
    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager)
    fun reset()
    val loadMoreEvent: Observable<Int>
}
