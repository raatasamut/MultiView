package com.appimake.multiview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.BaseAdapter
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.MultiViewAdapter
import com.appimake.multirecyclerview.view.title.ViewTitleData
import com.appimake.multiview.custom.card.ImageCardData
import com.appimake.multiview.custom.card.ImageCardModel
import com.viven.imagezoom.ImageZoomHelper
import android.view.MotionEvent
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import com.appimake.multirecyclerview.view.gallery.ViewGalleryData
import com.appimake.multirecyclerview.view.gallery.ViewGalleryDataModel


class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var imageZoomHelper: ImageZoomHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//            val decorView = window.decorView
//            val uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            decorView.systemUiVisibility = uiOptions
        setContentView(R.layout.activity_main)

        imageZoomHelper = ImageZoomHelper(this);

        val cellList = arrayListOf<BaseMultiViewData>()
        cellList.add(ViewTitleData("A"))

        cellList.add(ViewGalleryData(ViewGalleryDataModel(arrayListOf(
                "https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/443446/pexels-photo-443446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/490411/pexels-photo-490411.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                "https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/68147/waterfall-thac-dray-nur-buon-me-thuot-daklak-68147.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/443446/pexels-photo-443446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/490411/pexels-photo-490411.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/164229/pexels-photo-164229.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))
        cellList.add(ImageCardData(ImageCardModel("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260", "Image")))

        viewManager = LinearLayoutManager(this)
        viewAdapter = MultiViewAdapter(this, cellList)

        recyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).apply {
            layoutManager = viewManager
            adapter = viewAdapter

        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return imageZoomHelper.onDispatchTouchEvent(ev) || super.dispatchTouchEvent(ev)
    }
}
