package com.appimake.multiview.custom.map

import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multiview.R

class MapViewData(var mapDataModel: MapViewModel) : BaseMultiViewData {
    override fun getDataModel(): Any = mapDataModel

    override fun getName(): String = "Map View"

    override fun getType(): Int = this.hashCode()

    override fun getLayout(): Int = R.layout.custom_cell_maps

    override fun getView(rootView: View): BaseMultiViewHolder = MapView(rootView)
}