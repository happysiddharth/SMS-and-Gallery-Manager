package com.example.basetemplate.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.RxPagingSource
import androidx.paging.rxjava2.flowable
import com.example.basetemplate.data.model.UserItem
import com.example.basetemplate.data.remote.NetworkService
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val networkService: NetworkService
){

    fun getUsers():Flowable<PagingData<UserItem>>{
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 5
            ),
            pagingSourceFactory = {UsersPagingSource()}
        ).flowable
    }

    inner class UsersPagingSource() : RxPagingSource<Int,UserItem>(){
        override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, UserItem>> {

                val position = params.key ?: 1
                return networkService.getPost(position)
                    .subscribeOn(Schedulers.io())
                    .map { toLoadResult(it,position) }
                    .onErrorReturn { throwable->
                        LoadResult.Error(throwable)
                    }
        }

        private fun toLoadResult(data:ArrayList<UserItem>,position:Int):LoadResult<Int,UserItem>{
            return LoadResult.Page(
                data = data,
                prevKey = if (position==1) null else position-1,
                nextKey = position + 1
            )
        }

    }
}