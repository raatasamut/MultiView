package com.appimake.multirecyclerview

import android.view.View

interface BaseMultiViewData {

    fun getName(): String
    fun getType(): Int
    fun getLayout(): Int
    fun getView(rootView: View): BaseMultiViewHolder
    fun getDataModel(): Any
}