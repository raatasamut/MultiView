package com.appimake.cellpool.cell.map

import android.view.View
import com.appimake.cellpool.R
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.google.android.gms.maps.*
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapView(itemView: View) : BaseMultiViewHolder(itemView), OnMapReadyCallback {

    private lateinit var data: MapViewModel

    lateinit var mapView: MapView
    var map: GoogleMap? = null

    override fun bindType(item: BaseMultiViewData) {
        itemView.isClickable = false

        data = item.getDataModel() as MapViewModel
        mapView = itemView.findViewById(R.id.cell_map_map)

        mapView.onCreate(null)
        mapView.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap?) {
        MapsInitializer.initialize(itemView.context)
        map = googleMap
        setMapLocation()
    }

    private fun setMapLocation() {
        if (map == null) return
        // Add a marker for this item and set the camera
        map!!.addMarker(MarkerOptions()
                .position(LatLng(data.lat, data.lng)))
        map!!.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(data.lat, data.lng), data.zoomLevel))

        // Set the map type back to normal.
        map!!.mapType = GoogleMap.MAP_TYPE_NORMAL
    }
}