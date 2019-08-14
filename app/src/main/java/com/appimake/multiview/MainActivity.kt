package com.appimake.multiview

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.appimake.multirecyclerview.*
import com.appimake.multiview.conponent.cell_001.Cell001DataModel
import com.appimake.multiview.conponent.cell_001.DataCell_001
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val testValue: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testValue.postValue(1)

        val cellList = arrayListOf<BaseMultiViewData>()

        cellList.add(DataCell_001(Cell001DataModel("AA", testValue)))
        cellList.add(DataCell_001(Cell001DataModel("BB", testValue)))
        cellList.add(DataCell_001(Cell001DataModel("CC", testValue)))
        cellList.add(DataCell_001(Cell001DataModel("DD", testValue)))
        cellList.add(DataCell_001(Cell001DataModel("EE", testValue)))

        main_recycler_view.setup(cellList)

//        main_recycler_view.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = MultiViewAdapter(this@MainActivity, cellList)
//            setHasFixedSize(true)
//        }

//        // Set swipe left right
//
//        val multiSwipeController = MultiSwipeController(recyclerView, object : MultiSwipeControllerActions() {
//            override fun onLeftClicked(position: Int, data: BaseMultiViewData) {
//                super.onLeftClicked(position, data)
//                Log.d("Swipe", "Left on position : $position")
//            }
//
//            override fun onRightClicked(position: Int, data: BaseMultiViewData) {
//                super.onRightClicked(position, data)
//                Log.d("Swipe", "Right on position : $position")
//            }
//        }, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
//
//        multiSwipeController.apply {
//            buttonWidth = 300f
//            buttonMargin = 22f
//            buttonLeft = SwipeButton("ANT", Color.BLACK, 30f)
//            buttonRight = SwipeButton("DOG", Color.MAGENTA, 30f)
//        }

        // End. Set swipe left right
    }
}
