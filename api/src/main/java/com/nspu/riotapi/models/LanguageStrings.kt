package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class LanguageStrings(var data: Map<String, String>? = null,
                           var version: String? = null,
                           var type: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            emptyMap<String, String>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeMap(data)
        writeString(version)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LanguageStrings> = object : Parcelable.Creator<LanguageStrings> {
            override fun createFromParcel(source: Parcel): LanguageStrings = LanguageStrings(source)
            override fun newArray(size: Int): Array<LanguageStrings?> = arrayOfNulls(size)
        }
    }
}