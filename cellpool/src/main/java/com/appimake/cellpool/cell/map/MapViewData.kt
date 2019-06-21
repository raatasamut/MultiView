package com.appimake.cellpool.cell.map

import android.view.View
import com.appimake.cellpool.R
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder

class MapViewData(var mapDataModel: MapViewModel) : BaseMultiViewData {
    override fun isValid(): Boolean = true

    override fun getDataModel(): Any = mapDataModel

    override fun getName(): String = "Map View"

    override fun getType(): Int = this.hashCode()

    override fun getLayout(): Int = R.layout.cell_map

    override fun getView(rootView: View): BaseMultiViewHolder = MapView(rootView)
}

data class MapViewModel(var title: String, var lat: Double, var lng: Double, var zoomLevel: Float)