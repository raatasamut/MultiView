package com.appimake.multirecyclerview.view.title

import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multirecyclerview.R

class ViewTitleData(var title: String) : BaseMultiViewData {
    override fun getDataModel(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayout(): Int = R.layout.cell_title

    override fun getType(): Int = this.hashCode()

    override fun getName(): String = title

    override fun getView(rootView : View): BaseMultiViewHolder = ViewTitle(rootView)
}