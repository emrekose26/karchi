package com.emrekose.karchi.ui.main

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.emrekose.karchi.data.local.entity.Repos
import com.emrekose.karchi.databinding.ItemRepoBinding
import com.emrekose.karchi.ui.BaseAdapter

/**
 * Created by emrekose on 14.12.2017.
 */
class RepoListRecyclerAdapter(var callback: RepoCallback) : BaseAdapter<RepoListRecyclerAdapter.ViewHolder, Repos>() {

    var repoList: ArrayList<Repos> = ArrayList()

    override fun setData(dataList: List<Repos>) {
        val diffCallback = DiffUtil.calculateDiff(RepoDiffCallback(repoList, dataList))
        with(repoList) { clear(); addAll(dataList) }
        diffCallback.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = repoList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder.create(LayoutInflater.from(parent?.context), parent, callback)

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(repoList[position])
    }

    class ViewHolder(val itemRepoBinding: ItemRepoBinding, val callback: RepoCallback) : RecyclerView.ViewHolder(itemRepoBinding.root) {
        companion object {
            fun create(layoutInflater: LayoutInflater, parent: ViewGroup?, callback: RepoCallback): ViewHolder {
                val itemRepoBinding = ItemRepoBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(itemRepoBinding, callback)
            }
        }

        init {
            itemRepoBinding.root.setOnClickListener {
                callback.let { callback.onRepoClick(itemRepoBinding.repo) }
            }
        }

        fun bind(repos: Repos) {
            itemRepoBinding.apply {
                repo = repos
                executePendingBindings()
            }
        }

    }
}