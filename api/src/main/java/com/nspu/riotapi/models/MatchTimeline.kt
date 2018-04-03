package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class MatchTimeline(
        var frames: List<MatchFrame>? = null,
        var frameInterval: Long? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(MatchFrame.CREATOR),
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(frames)
        writeValue(frameInterval)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchTimeline> = object : Parcelable.Creator<MatchTimeline> {
            override fun createFromParcel(source: Parcel): MatchTimeline = MatchTimeline(source)
            override fun newArray(size: Int): Array<MatchTimeline?> = arrayOfNulls(size)
        }
    }
}