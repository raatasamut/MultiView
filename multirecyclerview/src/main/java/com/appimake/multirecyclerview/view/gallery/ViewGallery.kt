package com.appimake.multirecyclerview.view.gallery

import android.content.Context
import android.support.v7.recyclerview.R.attr.layoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.appimake.multirecyclerview.BaseMultiViewData
import com.appimake.multirecyclerview.BaseMultiViewHolder
import com.appimake.multirecyclerview.MultiViewAdapter
import com.appimake.multirecyclerview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.fitCenterTransform

class ViewGallery(itemView: View) : BaseMultiViewHolder(itemView) {
    override fun bindType(item: BaseMultiViewData) {

        lateinit var recyclerView: RecyclerView
        lateinit var viewAdapter: RecyclerView.Adapter<*>
        lateinit var viewManager: RecyclerView.LayoutManager

        viewManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        viewAdapter = GalleryAdapter(itemView.context, (item.getDataModel() as ViewGalleryDataModel).imageListURL)

        recyclerView = itemView.findViewById<RecyclerView>(R.id.cell_gallery_rv).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}

class GalleryAdapter(val context: Context, val imageListURL: ArrayList<String>) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
                .load(imageListURL[position])
                .apply(fitCenterTransform())
                .into(holder.ivImage);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_gallery_view, parent, false))

    override fun getItemCount(): Int = imageListURL.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivImage = itemView.findViewById<ImageView>(R.id.cell_gallery_view_image)
    }
}