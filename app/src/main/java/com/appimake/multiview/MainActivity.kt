package com.appimake.multiview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Log
import com.appimake.cellpool.cell.card.ImageCardData
import com.appimake.cellpool.cell.card.ImageCardModel
import com.appimake.cellpool.cell.gallery.ViewGalleryData
import com.appimake.cellpool.cell.gallery.ViewGalleryDataModel
import com.appimake.cellpool.cell.map.MapView
import com.appimake.cellpool.cell.map.MapViewData
import com.appimake.cellpool.cell.map.MapViewModel
import com.appimake.cellpool.cell.title.ViewTitleData
import com.appimake.multirecyclerview.*
import com.google.android.gms.maps.GoogleMap


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cellList = arrayListOf<BaseMultiViewData>()
        cellList.add(ViewTitleData("Gallery"))
        cellList.add(ViewGalleryData(ViewGalleryDataModel(arrayListOf(
                "https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/443446/pexels-photo-443446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/490411/pexels-photo-490411.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))))

        cellList.add(ViewTitleData("Picture"))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))

        cellList.add(ViewTitleData("Map"))
        cellList.add(MapViewData(MapViewModel("Map", 13.7182685, 100.5039475, 15f)))

        viewManager = LinearLayoutManager(this)
        viewAdapter = MultiViewAdapter(this, cellList)
        recyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter
            setHasFixedSize(true)
        }

        // Use for clear map on MapView
        recyclerView.setRecyclerListener {
            if (it is MapView && it.map != null) {
                it.map!!.clear()
                it.map!!.mapType = GoogleMap.MAP_TYPE_NONE
            }
        }

        // Set swipe left right

        val multiSwipeController = MultiSwipeController(recyclerView, object : MultiSwipeControllerActions() {
            override fun onLeftClicked(position: Int, data: BaseMultiViewData) {
                super.onLeftClicked(position, data)
                Log.d("Swipe", "Left on position : $position")
            }

            override fun onRightClicked(position: Int, data: BaseMultiViewData) {
                super.onRightClicked(position, data)
                Log.d("Swipe", "Right on position : $position")
            }
        }, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        multiSwipeController.apply {
            buttonWidth = 300f
            buttonMargin = 22f
            buttonLeft = SwipeButton("ANT", Color.BLACK, 30f)
            buttonRight = SwipeButton("DOG", Color.MAGENTA, 30f)
        }

        // End. Set swipe left right
    }
}
