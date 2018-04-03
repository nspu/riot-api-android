package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionBlockData(var items: List<ChampionRecommandedBlockItem>? = null,
                             var recMath: Boolean? = null,
                             var type: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(ChampionRecommandedBlockItem.CREATOR),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(items)
        writeValue(recMath)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionBlockData> = object : Parcelable.Creator<ChampionBlockData> {
            override fun createFromParcel(source: Parcel): ChampionBlockData = ChampionBlockData(source)
            override fun newArray(size: Int): Array<ChampionBlockData?> = arrayOfNulls(size)
        }
    }
}