package com.example.instagramplayingvideoonrecyclertview.ui

import android.R
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.instagramplayingvideoonrecyclertview.model.MediaObject
import kotlinx.android.synthetic.main.layout_video_list_item.view.*
import java.lang.System.load


class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var parent: View
    var requestManager: RequestManager? = null

    fun onBind(mediaObject: MediaObject, _requestManager: RequestManager?) {
        requestManager = _requestManager
        itemView.setTag(this)
        itemView.title.text = mediaObject.title


        //request manager is like using Glide().load().into
        requestManager
            ?.load(mediaObject.thumbnail)
            ?.into(parent.thumbnail)
    }

    init {
        parent = itemView
    }
}