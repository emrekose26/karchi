package com.emrekose.karchi.di

import com.emrekose.karchi.ui.detail.DetailFragment
import com.emrekose.karchi.ui.main.RepoListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by emrekose on 13.12.2017.
 */
@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeRepoListFragment(): RepoListFragment


    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

}