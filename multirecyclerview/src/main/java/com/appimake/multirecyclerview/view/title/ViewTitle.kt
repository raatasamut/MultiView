package com.appimake.multirecyclerview.view.title

import android.view.View
import android.widget.TextView
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multirecyclerview.R

class ViewTitle(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun bindType(item: BaseMultiViewData) {

        val tvTitle = itemView.findViewById<TextView>(R.id.cell_title_title)
        tvTitle.text = item.getName()
    }
}