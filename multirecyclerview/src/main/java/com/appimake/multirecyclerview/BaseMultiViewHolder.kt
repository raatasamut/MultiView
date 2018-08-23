package com.appimake.multirecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseMultiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindType(item: BaseMultiViewData)

    open fun canSwipe(): Boolean = false
}