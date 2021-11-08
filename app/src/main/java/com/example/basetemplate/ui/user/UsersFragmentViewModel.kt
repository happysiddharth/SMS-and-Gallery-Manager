package com.example.basetemplate.ui.user

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.rxjava2.cachedIn
import com.example.basetemplate.data.model.UserItem
import com.example.basetemplate.data.repository.UsersRepository
import com.example.basetemplate.ui.base.BaseViewModel
import com.example.basetemplate.util.log.Logger
import com.example.basetemplate.util.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class UsersFragmentViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val usersRepository: UsersRepository
) : BaseViewModel(networkHelper, compositeDisposable) {

    val users:MutableLiveData<PagingData<UserItem>> = MutableLiveData()

    @SuppressLint("CheckResult")
    override fun onCreate() {
       compositeDisposable.addAll(
           usersRepository.getUsers()
               .cachedIn(viewModelScope)
               .subscribe ({
                   users.postValue(it)
               },{

               })
       )
    }
}