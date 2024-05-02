package com.rntvideoplayer

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RNTVideoPlayerManagerDelegate
import com.facebook.react.viewmanagers.RNTVideoPlayerManagerInterface

class VideoPlayerManager(private val context: ReactApplicationContext) :
        SimpleViewManager<VideoPlayer>(),
        RNTVideoPlayerManagerInterface<VideoPlayer> {

                private val mDelegate: ViewManagerDelegate<VideoPlayer>

                init {
                        mDelegate = RNTVideoPlayerManagerDelegate(this)
                }

                override fun getDelegate(): ViewManagerDelegate<VideoPlayer> {
                        return mDelegate
                }

                override fun getName(): String {
                        return NAME
                }

                companion object {
                        const val NAME = "RNTVideoPlayer"
                }

                override fun createViewInstance(p0: ThemedReactContext): VideoPlayer {
                        return VideoPlayer(context, context.currentActivity!!)
                }

                @ReactProp(name = "url")
                override fun setUrl(view: VideoPlayer?, value: String?) {
                        view?.setUpPlayer(value!!)
                }

        }
