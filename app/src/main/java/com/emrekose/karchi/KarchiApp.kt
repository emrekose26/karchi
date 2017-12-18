package com.emrekose.karchi

import android.app.Activity
import android.app.Application
import com.emrekose.karchi.di.DaggerAppComponent
import com.emrekose.karchi.utils.extensions.debug
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by emrekose on 11.12.2017.
 */
class KarchiApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispathingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        initInjector()

        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)

        debug {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispathingActivityInjector

    private fun initInjector() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

}