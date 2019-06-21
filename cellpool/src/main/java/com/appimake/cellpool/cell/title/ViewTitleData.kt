package com.appimake.cellpool.cell.title

import android.view.View
import com.appimake.cellpool.R
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder

class ViewTitleData(var title: String) : BaseMultiViewData {

    override fun isValid(): Boolean = true

    override fun getDataModel(): Any = 0

    override fun getLayout(): Int = R.layout.cell_title

    override fun getType(): Int = this.hashCode()

    override fun getName(): String = title

    override fun getView(rootView: View): BaseMultiViewHolder = ViewTitle(rootView)
}