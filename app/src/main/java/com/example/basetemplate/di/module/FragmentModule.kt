package com.example.basetemplate.di.module

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basetemplate.data.remote.NetworkService
import com.example.basetemplate.data.repository.UsersRepository
import com.example.basetemplate.ui.base.BaseFragment
import com.example.basetemplate.ui.user.UsersFragmentViewModel
import com.example.basetemplate.util.ViewModelFactory
import com.example.basetemplate.util.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment:BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideGridLayoutManager(): GridLayoutManager = GridLayoutManager(fragment.context,2)

    @Provides
    fun getActivity():Activity{
        return fragment.requireActivity()
    }

    @Provides
    fun getUsersViewModel(
        networkHelper: NetworkHelper,
        usersRepository: UsersRepository,
        compositeDisposable: CompositeDisposable
    ): UsersFragmentViewModel = ViewModelProviders.of(fragment,
        ViewModelFactory(UsersFragmentViewModel::class){
            UsersFragmentViewModel(compositeDisposable, networkHelper, usersRepository)
        }).get(UsersFragmentViewModel::class.java)



}