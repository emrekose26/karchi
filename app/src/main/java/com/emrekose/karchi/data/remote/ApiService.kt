package com.emrekose.karchi.data.remote

import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.data.local.entity.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by emrekose on 13.12.2017.
 */
interface ApiService {

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Single<User>

    @GET("users/{username}/repos")
    fun getUserRepos(@Path("username") username: String): Single<List<Repos>>
}