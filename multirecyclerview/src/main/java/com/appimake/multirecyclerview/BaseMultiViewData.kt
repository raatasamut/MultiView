package com.appimake.multirecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View

interface BaseMultiViewData {

    fun getName(): String
    fun getType(): Int
    fun getLayout(): Int
    fun getView(rootView: View): BaseMultiViewHolder
    fun getDataModel(): Any
    fun isValid(): Boolean
}

fun BaseMultiViewData.toView(context: Context): View {
    val v = LayoutInflater
            .from(context)
            .inflate(this.getLayout(), null, false)
    this.getView(v).bindType(this)
    return v
}