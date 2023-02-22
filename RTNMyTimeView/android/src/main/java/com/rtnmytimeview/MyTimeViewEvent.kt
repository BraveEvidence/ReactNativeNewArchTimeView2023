package com.rtnmytimeview

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTModernEventEmitter

class MyTimeViewEvent(viewId: Int, private val time: String) :
    Event<MyTimeViewEvent>(viewId) {

    override fun getEventName(): String {
        return "topOnTimePicked"
    }

    override fun dispatchModern(rctEventEmitter: RCTModernEventEmitter?) {
        super.dispatchModern(rctEventEmitter)
        rctEventEmitter?.receiveEvent(
            -1,
            viewTag, eventName,
            Arguments.createMap()
        )
    }

    override fun getEventData(): WritableMap {
        val event: WritableMap = Arguments.createMap()
        event.putString("value", time)
        return event
    }
}