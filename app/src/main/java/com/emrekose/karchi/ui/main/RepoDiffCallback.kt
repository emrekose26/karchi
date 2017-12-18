package com.emrekose.karchi.ui.main

import android.support.v7.util.DiffUtil
import com.emrekose.karchi.data.local.entity.Repos

/**
 * Created by emrekose on 16.12.2017.
 */
class RepoDiffCallback(var oldRepoList: List<Repos>, var newRepoList: List<Repos>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldRepoList.size

    override fun getNewListSize(): Int = newRepoList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldRepoList[oldItemPosition].repoId == newRepoList[newItemPosition].repoId

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldRepoList[oldItemPosition].equals(newRepoList[newItemPosition])
}