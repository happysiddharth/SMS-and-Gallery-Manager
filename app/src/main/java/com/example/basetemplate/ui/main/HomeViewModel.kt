package com.example.basetemplate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basetemplate.ui.base.BaseViewModel
import com.example.basetemplate.util.common.Event
import com.example.basetemplate.util.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel (networkHelper: NetworkHelper,
                     val compositeDisposable: CompositeDisposable)
    : BaseViewModel(networkHelper,compositeDisposable) {
    override fun onCreate() {

    }


}