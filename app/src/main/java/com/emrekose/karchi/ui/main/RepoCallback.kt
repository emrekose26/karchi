package com.emrekose.karchi.ui.main

import com.emrekose.karchi.data.local.entity.Repos

/**
 * Created by emrekose on 15.12.2017.
 */
interface RepoCallback {
    fun onRepoClick(repos: Repos?)
}