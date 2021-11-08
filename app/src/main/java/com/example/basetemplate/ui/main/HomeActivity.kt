package com.example.basetemplate.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.basetemplate.R
import com.example.basetemplate.di.component.ActivityComponent
import com.example.basetemplate.ui.base.BaseActivity
import com.example.basetemplate.ui.user.UsersFragment
import kotlinx.android.synthetic.main.home_layout.*

class HomeActivity() : BaseActivity<HomeViewModel>() {

    val users = ArrayList<String>()
    private var activeFragment: Fragment? = null

    override fun provideLayoutId(): Int = R.layout.home_layout


    override fun setupView(savedInstanceState: Bundle?) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_dash,UsersFragment(),UsersFragment.TAG)
            .commit()
    }



    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setUpToolBar(): Toolbar = findViewById(R.id.my_toolbar)

    override fun setObservers() {
        super.setObservers()

    }



}