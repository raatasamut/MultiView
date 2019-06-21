package com.appimake.multirecyclerview

import androidx.recyclerview.widget.RecyclerView
import android.view.View

abstract class BaseMultiViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    abstract fun bindType(item: BaseMultiViewData)

    open fun canSwipe(): Boolean = false
}