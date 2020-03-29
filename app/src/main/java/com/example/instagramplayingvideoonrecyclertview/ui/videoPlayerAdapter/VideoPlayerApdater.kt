package com.example.instagramplayingvideoonrecyclertview.ui.videoPlayerAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.instagramplayingvideoonrecyclertview.R
import com.example.instagramplayingvideoonrecyclertview.model.MediaObject
import com.example.instagramplayingvideoonrecyclertview.ui.VideoPlayerViewHolder

class VideoPlayerApdater(
    private val mediaObjects: ArrayList<MediaObject>,
    private val requestManager: RequestManager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return VideoPlayerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_video_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mediaObjects.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VideoPlayerViewHolder).onBind(mediaObjects[position], requestManager)

    }
}