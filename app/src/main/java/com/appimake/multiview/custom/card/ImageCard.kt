package com.appimake.multiview.custom.card

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multiview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.fitCenterTransform
import com.viven.imagezoom.ImageZoomHelper

class ImageCard(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun bindType(item: BaseMultiViewData) {

        var ivImage = itemView.findViewById<ImageView>(R.id.custom_cell_image_card_image)
        var tvTitle = itemView.findViewById<TextView>(R.id.custom_cell_image_card_title)

        Glide.with(itemView.context)
                .load((item.getDataModel() as ImageCardModel).url)
                .apply(fitCenterTransform())
                .into(ivImage);

        tvTitle.text = item.getName()

        ImageZoomHelper.setViewZoomable(itemView.findViewById(R.id.custom_cell_image_card_image));
    }
}