package com.appimake.multirecyclerview.recycler

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.MultiViewAdapter
import com.appimake.multirecyclerview.R
import kotlinx.android.synthetic.main.custom_recycler_view.view.*

class CustomRecyclerView: FrameLayout {

    constructor(context: Context): super(context) { this.setup() }
    constructor(context: Context, attrs: AttributeSet): super(context, attrs) { this.setup() }

    private fun setup(){
        this.setupLayout()
    }

    private fun setupLayout() { inflate(context!!, R.layout.custom_recycler_view, this) }

    fun getRAWRecyclerView() = custom_recycler_view_rv

    fun getRAWLoadingView() = custom_recycler_view_loading

    fun getRAWNotFoundView() = custom_recycler_view_not_found

    fun setup(cellList: ArrayList<BaseMultiViewData>, lm: RecyclerView.LayoutManager? = LinearLayoutManager(context)): CustomRecyclerView{
        custom_recycler_view_rv.apply {
            layoutManager = lm
            adapter = MultiViewAdapter(context, cellList)
            setHasFixedSize(true)
        }
        hideLoading()

        if(cellList.isEmpty())
            showNotFound()
        else
            hideNotFound()

        return this
    }

    fun useDivider(divider: Int = R.drawable.cell_divider): CustomRecyclerView {
        getRAWRecyclerView().addItemDecoration(DividerItemDecorator(resources.getDrawable(divider, null)))
        return this
    }

    fun showLoading(){
        custom_recycler_view_loading.visibility = View.GONE
        custom_recycler_view_rv.visibility = View.VISIBLE
    }

    fun hideLoading(){
        custom_recycler_view_loading.visibility = View.GONE
        custom_recycler_view_rv.visibility = View.VISIBLE
    }

    fun showNotFound(){
        custom_recycler_view_not_found.visibility = View.VISIBLE
    }

    fun hideNotFound(){
        custom_recycler_view_not_found.visibility = View.GONE
    }
}