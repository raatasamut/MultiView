package com.appimake.multirecyclerview.view.gallery

import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multirecyclerview.R

class ViewGalleryData(val dataModel: ViewGalleryDataModel) : BaseMultiViewData {
    override fun getName(): String = "Gallery"

    override fun getType(): Int = this.hashCode()

    override fun getLayout(): Int = R.layout.cell_gallery

    override fun getView(rootView: View): BaseMultiViewHolder = ViewGallery(rootView)

    override fun getDataModel(): Any = dataModel
}

data class ViewGalleryDataModel(val imageListURL: ArrayList<String>)