package com.appimake.multiview.custom.card

import android.view.View
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multiview.R

class ImageCardData(var imageDataModel: ImageCardModel) : BaseMultiViewData {
    override fun getDataModel(): Any = imageDataModel

    override fun getName(): String = "Image Card"

    override fun getType(): Int = this.hashCode()

    override fun getLayout(): Int = R.layout.custom_cell_image_card

    override fun getView(rootView: View): BaseMultiViewHolder = ImageCard(rootView)
}