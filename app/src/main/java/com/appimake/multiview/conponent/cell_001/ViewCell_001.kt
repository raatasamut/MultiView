package com.appimake.multiview.conponent.cell_001

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import kotlinx.android.synthetic.main.cell_001.view.*

class ViewCell_001(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun bindType(item: BaseMultiViewData) {

        (item.getDataModel() as Cell001DataModel).let { data: Cell001DataModel ->

            itemView.cell_001_value.text = data.value.value.toString()

            data.value.observe(itemView.context as LifecycleOwner, Observer {
                it?.let {
                    itemView.cell_001_value.text = it.toString()
                }
            })

            itemView.cell_001_minus.setOnClickListener {
                data.value.value = data.value.value!! - 1
            }

            itemView.cell_001_plus.setOnClickListener {
                data.value.value = data.value.value!! + 1
            }
        }

    }
}