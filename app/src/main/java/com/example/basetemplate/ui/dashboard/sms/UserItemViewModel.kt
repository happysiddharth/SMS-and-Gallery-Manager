package com.example.basetemplate.ui.dashboard.sms

import androidx.lifecycle.MutableLiveData
import com.example.basetemplate.data.model.SMS
import com.example.basetemplate.ui.base.BaseItemViewModel
import com.example.basetemplate.util.common.Event
import com.example.basetemplate.util.common.Resource
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UserItemViewModel @Inject constructor(
    networkHelper: NetworkHelper,
    compositeDisposable: CompositeDisposable
) : BaseItemViewModel<SMS>(networkHelper,compositeDisposable) {

    val bottomSheet:MutableLiveData<Event<Resource<SMS>>> = MutableLiveData()
    override fun onCreate() {

    }

    public fun changeDataInList(){
    }

    public fun openBottomSheet(sms: SMS){
        bottomSheet.postValue(Event(Resource.success(sms)))
    }



}