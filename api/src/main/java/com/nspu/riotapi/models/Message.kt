package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class Message(
        var severity: String? = null,
        var author: String? = null,
        var created_at: String? = null,
        var translations: List<Translation>? = null,
        var updated_at: String? = null,
        var content: String? = null,
        var id: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.createTypedArrayList(Translation.CREATOR),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(severity)
        writeString(author)
        writeString(created_at)
        writeTypedList(translations)
        writeString(updated_at)
        writeString(content)
        writeString(id)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Message> = object : Parcelable.Creator<Message> {
            override fun createFromParcel(source: Parcel): Message = Message(source)
            override fun newArray(size: Int): Array<Message?> = arrayOfNulls(size)
        }
    }
}