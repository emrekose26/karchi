package com.emrekose.karchi.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.repository.KarchiRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by emrekose on 13.12.2017.
 */
class RepoListViewModel @Inject constructor(private val karchiRepository: KarchiRepository): ViewModel() {

    val disposable = CompositeDisposable()

    val repoLiveList = MutableLiveData<List<Repos>>()

    val repoList: LiveData<List<Repos>>
        get() = repoLiveList

    fun getRepoList(username: String): LiveData<List<Repos>> {
        disposable.add(karchiRepository.getRepoList(username)
                .subscribe { response ->
                    repoLiveList.value = response
                })
        return repoList
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}