package com.appimake.multirecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MultiViewAdapter(val context: Context, val listItem: ArrayList<BaseMultiViewData>) : RecyclerView.Adapter<BaseMultiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMultiViewHolder {
        var viewData = findLayout(viewType)
        var view = LayoutInflater
                .from(parent.context)
                .inflate(viewData.getLayout(), parent, false)

        return viewData.getView(view)
    }

    fun findLayout(type: Int): BaseMultiViewData {
        var cell: BaseMultiViewData? = null
        for (item in listItem) {
            if (item.getType() == type)
                cell = item
        }
        return cell!!
    }

    fun getItemData(position: Int): BaseMultiViewData {
        return listItem[position]
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: BaseMultiViewHolder, position: Int) {
        holder.bindType(listItem[position])
    }

    override fun getItemViewType(position: Int): Int {
        return listItem[position].getType()
    }
}