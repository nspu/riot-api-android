package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class Incident(
        var active: Boolean? = null,
        var created_at: String? = null,
        var id: Long? = null,
        var updates: List<Message>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.createTypedArrayList(Message.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(active)
        writeString(created_at)
        writeValue(id)
        writeTypedList(updates)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Incident> = object : Parcelable.Creator<Incident> {
            override fun createFromParcel(source: Parcel): Incident = Incident(source)
            override fun newArray(size: Int): Array<Incident?> = arrayOfNulls(size)
        }
    }
}