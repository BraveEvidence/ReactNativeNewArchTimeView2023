package com.rtnmytimeview

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.viewmanagers.RTNMyTimeViewManagerDelegate
import com.facebook.react.viewmanagers.RTNMyTimeViewManagerInterface


class MyTimeViewManager(private val context: ReactApplicationContext) :
    SimpleViewManager<MyTimeView>(),
    RTNMyTimeViewManagerInterface<MyTimeView> {

    private val mDelegate: ViewManagerDelegate<MyTimeView>

    init {
        mDelegate = RTNMyTimeViewManagerDelegate(this)
    }

    override fun getDelegate(): ViewManagerDelegate<MyTimeView> {
        return mDelegate
    }

    override fun getName(): String {
        return NAME
    }

    companion object {
        const val NAME = "RTNMyTimeView"
    }

    override fun createViewInstance(p0: ThemedReactContext): MyTimeView {
        return MyTimeView(context,context.currentActivity!!)
    }

    override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any>? {
        return MapBuilder.of(
            "topOnTimePicked",
            MapBuilder.of("registrationName", "onTimePicked")
        )
    }

}