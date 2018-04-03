package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ItemGroup(
        var MaxGroupOwnable: String? = null,
        var key: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(MaxGroupOwnable)
        writeString(key)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemGroup> = object : Parcelable.Creator<ItemGroup> {
            override fun createFromParcel(source: Parcel): ItemGroup = ItemGroup(source)
            override fun newArray(size: Int): Array<ItemGroup?> = arrayOfNulls(size)
        }
    }
}