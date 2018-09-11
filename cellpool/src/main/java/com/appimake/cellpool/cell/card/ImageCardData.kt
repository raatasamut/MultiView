package com.appimake.cellpool.cell.card

import android.view.View
import com.appimake.cellpool.R
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder

class ImageCardData(var imageDataModel: ImageCardModel) : BaseMultiViewData {
    override fun getDataModel(): Any = imageDataModel

    override fun getName(): String = "Image Card"

    override fun getType(): Int = this.hashCode()

    override fun getLayout(): Int = R.layout.cell_image_card

    override fun getView(rootView: View): BaseMultiViewHolder = ImageCard(rootView)
}

data class ImageCardModel(var url: String, var title: String)