package com.rtnmytimeview

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.events.EventDispatcher
import java.util.*


class MyTimeView(context: Context,currentActivity: Activity): View(context) {
    private var currentDateTime: Calendar = Calendar.getInstance()
    private val mHour = currentDateTime.get(Calendar.HOUR_OF_DAY)
    private val mMinute = currentDateTime.get(Calendar.MINUTE)
    var reactContext = getContext() as ReactContext

    init {
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        setLayoutParams(layoutParams)

        val timePickerDialog = TimePickerDialog(currentActivity,
            { view, hour, minute ->
                val timeHour  = if(hour <= 9) {
                    "0$hour"
                } else
                {
                    hour
                }
                val timeMinute = if(minute <= 9){
                    "0$minute"
                } else {
                    minute
                }
                val eventDispatcher: EventDispatcher? =
                    UIManagerHelper.getEventDispatcherForReactTag(
                        reactContext, id
                    )
                eventDispatcher?.dispatchEvent(MyTimeViewEvent(id,"$timeHour $timeMinute"))
            }, mHour, mMinute, false
        )
        timePickerDialog.show()
    }

}