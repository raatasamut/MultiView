package com.appimake.cellpool.cell.gallery

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.appimake.cellpool.R
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.fitCenterTransform
import kotlinx.android.synthetic.main.cell_gallery.view.*

class ViewGallery(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun bindType(item: BaseMultiViewData) {

        lateinit var viewAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>
        lateinit var viewManager: androidx.recyclerview.widget.RecyclerView.LayoutManager

        viewManager = LinearLayoutManager(itemView.context, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        viewAdapter = GalleryAdapter(itemView.context, (item.getDataModel() as ViewGalleryDataModel).imageListURL)

        itemView.cell_gallery_rv.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}

private class GalleryAdapter(val context: Context, val imageListURL: ArrayList<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
                .load(imageListURL[position])
                .apply(fitCenterTransform())
                .into(holder.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_gallery_view, parent, false))

    override fun getItemCount(): Int = imageListURL.size

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var ivImage = itemView.findViewById<ImageView>(R.id.cell_gallery_view_image)
    }
}