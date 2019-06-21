package com.appimake.cellpool.cell.card

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.appimake.cellpool.R
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.fitCenterTransform

class ImageCard(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun canSwipe(): Boolean = true

    override fun bindType(item: BaseMultiViewData) {

        var ivImage = itemView.findViewById<ImageView>(R.id.cell_image_card_image)
        var tvTitle = itemView.findViewById<TextView>(R.id.cell_image_card_title)

        Glide.with(itemView.context)
                .load((item.getDataModel() as ImageCardModel).url)
                .apply(fitCenterTransform())
                .into(ivImage)

        tvTitle.text = (item.getDataModel() as ImageCardModel).title


    }
}