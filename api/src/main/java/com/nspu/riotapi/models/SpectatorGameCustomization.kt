package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class SpectatorGameCustomization(
        var category: String? = null,// 	Category identifier for Game Customization
        var content: String? = null// 	Game Customization content
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(category)
        writeString(content)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorGameCustomization> = object : Parcelable.Creator<SpectatorGameCustomization> {
            override fun createFromParcel(source: Parcel): SpectatorGameCustomization = SpectatorGameCustomization(source)
            override fun newArray(size: Int): Array<SpectatorGameCustomization?> = arrayOfNulls(size)
        }
    }
}