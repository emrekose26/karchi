package com.emrekose.karchi.di

import android.app.Application
import android.arch.persistence.room.Room
import com.emrekose.karchi.data.local.KarchiDatabase
import com.emrekose.karchi.data.local.dao.KarchiDao
import com.emrekose.karchi.data.remote.ApiService
import com.emrekose.karchi.utils.Constants
import com.emrekose.karchi.utils.extensions.debug
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by emrekose on 13.12.2017.
 */

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.apply {
            debug {
                addNetworkInterceptor(StethoInterceptor())
                addInterceptor(httpLoggingInterceptor)
            }
        }
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideKarchiDatabase(application: Application): KarchiDatabase =
            Room.databaseBuilder(application, KarchiDatabase::class.java, "karchi.db").build()

    @Provides
    @Singleton
    fun provideKarchiDao(karchiDatabase: KarchiDatabase): KarchiDao = karchiDatabase.karchiDao()

}