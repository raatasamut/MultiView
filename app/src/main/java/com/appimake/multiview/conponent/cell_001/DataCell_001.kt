package com.appimake.multiview.conponent.cell_001

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multiview.R

class DataCell_001(val dataModel: Cell001DataModel) : BaseMultiViewData {
    override fun isValid(): Boolean = true

    override fun getDataModel(): Any = dataModel

    override fun getName(): String = "Cell_001"

    override fun getType(): Int = this.hashCode()

    override fun getLayout(): Int = R.layout.cell_001

    override fun getView(rootView: View): BaseMultiViewHolder = ViewCell_001(rootView)
}

data class Cell001DataModel(var title: String, var value: MutableLiveData<Int>)