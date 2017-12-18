package com.emrekose.karchi.di

import com.emrekose.karchi.ui.detail.DetailActivity
import com.emrekose.karchi.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by emrekose on 13.12.2017.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilder::class))
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilder::class))
    abstract fun detailActivity(): DetailActivity
}