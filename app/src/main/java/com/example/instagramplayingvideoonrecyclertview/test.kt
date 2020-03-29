package com.example.instagramplayingvideoonrecyclertview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.instagramplayingvideoonrecyclertview.R
import com.example.instagramplayingvideoonrecyclertview.model.MediaObject
import com.example.instagramplayingvideoonrecyclertview.ui.VerticalSpacingItemDecorator
import com.example.instagramplayingvideoonrecyclertview.ui.recyclerView.VideoPlayerRecyclerView
import com.example.instagramplayingvideoonrecyclertview.ui.videoPlayerAdapter.VideoPlayerApdater
import com.example.instagramplayingvideoonrecyclertview.util.Resources
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private var mRecyclerView: VideoPlayerRecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.layoutManager = layoutManager
        val itemDecorator = VerticalSpacingItemDecorator(10)
        mRecyclerView!!.addItemDecoration(itemDecorator)
        val mediaObjects: ArrayList<MediaObject> =Resources.MEDIA_OBJECTS
        mRecyclerView!!.setMediaObjects(mediaObjects)
        val adapter =
            VideoPlayerApdater(mediaObjects, initGlide())
        mRecyclerView!!.adapter = adapter
    }

    private fun initGlide(): RequestManager {
        val options: RequestOptions = RequestOptions()
            .placeholder(R.drawable.white)
            .error(R.drawable.white)
        return Glide.with(this)
            .setDefaultRequestOptions(options)
    }

    override fun onDestroy() {
        if (mRecyclerView != null) mRecyclerView!!.releasePlayer()
        super.onDestroy()
    }
}