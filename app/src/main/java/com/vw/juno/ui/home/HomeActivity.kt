package com.vw.juno.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import com.vw.juno.R
import com.vw.juno.ui.base.BaseActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.home_activity.*
import javax.inject.Inject


class HomeActivity: BaseActivity(), IHomeView, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        supportActionBar?.hide()
        setViewPager()
    }

    fun setViewPager() {
        val movieAdapter = HomePagerAdapter(this, supportFragmentManager)
        home_viewpager.adapter = movieAdapter
        home_viewpager.offscreenPageLimit = 2
        home_sliding_tabs.setupWithViewPager(home_viewpager)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
            fragmentDispatchingAndroidInjector
}