package com.appimake.multiview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData

class MainAsView : AppCompatActivity() {

    val testValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

//        activity_view_cn.addView(ViewTitleData("Map").toView(this))
//        activity_view_cn.addView(ViewGalleryData(ViewGalleryDataModel(arrayListOf(
//                "https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
//                "https://images.pexels.com/photos/443446/pexels-photo-443446.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
//                "https://images.pexels.com/photos/490411/pexels-photo-490411.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
//                "https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"))).toView(this))
//
//        testValue.value = 3
//
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
//        activity_view_cn.addView(DataCell_001(Cell001DataModel("Test", testValue)).toView(this))
    }
}