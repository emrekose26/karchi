package com.emrekose.karchi.repository

import com.emrekose.karchi.data.local.dao.KarchiDao
import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.data.remote.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by emrekose on 13.12.2017.
 */
class KarchiRepository @Inject constructor(private val apiService: ApiService,
                                           private val karchiDao: KarchiDao) {

    fun getRepoList(username: String): Single<List<Repos>> {
        return apiService.getUserRepos(username).onErrorResumeNext {
            karchiDao.getReposFromDb(username)
        }.doOnSuccess {
            karchiDao.insertRepos(it)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}