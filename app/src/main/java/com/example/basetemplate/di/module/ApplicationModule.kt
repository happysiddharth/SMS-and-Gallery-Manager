package com.example.basetemplate.di.module

import com.example.basetemplate.MyApplication
import com.example.basetemplate.data.remote.NetworkService
import com.example.basetemplate.data.remote.Networking
import com.example.basetemplate.di.APIkey
import com.example.basetemplate.di.ApplicationScope
import com.example.basetemplate.util.common.Permissions
import com.example.basetemplate.util.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplicationModule(private val application:MyApplication) {

    @ApplicationScope
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @ApplicationScope
    @Provides
    fun providesNetworkService():NetworkService = Networking.create(apiKey(),"https://api.tvmaze.com/"
    ,application.cacheDir,502400)

    @ApplicationScope
    @APIkey
    fun apiKey():String = ""

    @ApplicationScope
    fun dbName():String = ""


    @ApplicationScope
    @Provides
    fun permissions(): Permissions{
        return Permissions
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()







}