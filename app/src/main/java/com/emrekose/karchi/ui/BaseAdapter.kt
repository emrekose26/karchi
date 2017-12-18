package com.emrekose.karchi.ui

import android.support.v7.widget.RecyclerView

/**
 * Created by emrekose on 14.12.2017.
 */
abstract class BaseAdapter<VH: RecyclerView.ViewHolder, in D>:  RecyclerView.Adapter<VH>() {

    abstract fun setData(dataList: List<D>)
}