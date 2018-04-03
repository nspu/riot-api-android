package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ShardStatus(
        var name: String? = null,
        var region_tag: String? = null,
        var hostname: String? = null,
        var services: List<Service>? = null,
        var slug: String? = null,
        var locales: List<String>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.createTypedArrayList(Service.CREATOR),
            source.readString(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(region_tag)
        writeString(hostname)
        writeTypedList(services)
        writeString(slug)
        writeStringList(locales)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ShardStatus> = object : Parcelable.Creator<ShardStatus> {
            override fun createFromParcel(source: Parcel): ShardStatus = ShardStatus(source)
            override fun newArray(size: Int): Array<ShardStatus?> = arrayOfNulls(size)
        }
    }
}