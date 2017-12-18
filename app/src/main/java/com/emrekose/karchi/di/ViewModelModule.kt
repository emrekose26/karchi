package com.emrekose.karchi.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.emrekose.karchi.ui.detail.DetailViewModel
import com.emrekose.karchi.ui.main.RepoListViewModel
import com.emrekose.karchi.viewmodel.VMFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by emrekose on 13.12.2017.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel::class)
    abstract fun bindsRepoListViewModel(repoListViewModel: RepoListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindsDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(vmFactory: VMFactory): ViewModelProvider.Factory

}