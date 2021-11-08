package com.example.basetemplate.data.remote

import com.example.basetemplate.data.model.UserItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET(EndPoints.getUsers)
    fun getPost(@Query("page") page:Int):Single<ArrayList<UserItem>>


}