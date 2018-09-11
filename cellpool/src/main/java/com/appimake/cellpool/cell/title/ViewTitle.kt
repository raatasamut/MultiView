package com.appimake.cellpool.cell.title

import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import kotlinx.android.synthetic.main.cell_title.view.*

class ViewTitle(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun bindType(item: BaseMultiViewData) {
        itemView.cell_title_title.text = item.getName()
    }
}