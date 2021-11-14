package com.example.basetemplate.ui.user.users

import com.example.basetemplate.data.model.UserItem
import com.example.basetemplate.ui.base.BaseItemViewModel
import com.example.basetemplate.util.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UserViewModel @Inject constructor(compositeDisposable: CompositeDisposable, networkHelper: NetworkHelper):
    BaseItemViewModel<UserItem>(networkHelper,compositeDisposable) {
    override fun onCreate() {

    }
}