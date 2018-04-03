package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionRecommandedData(
        var map: String? = null,
        var blocks: List<ChampionBlockData>? = null,
        var champion: String? = null,
        var title: String? = null,
        var priority: Boolean? = null,
        var mode: String? = null,
        var type: String? = null) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.createTypedArrayList(ChampionBlockData.CREATOR),
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(map)
        writeTypedList(blocks)
        writeString(champion)
        writeString(title)
        writeValue(priority)
        writeString(mode)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionRecommandedData> = object : Parcelable.Creator<ChampionRecommandedData> {
            override fun createFromParcel(source: Parcel): ChampionRecommandedData = ChampionRecommandedData(source)
            override fun newArray(size: Int): Array<ChampionRecommandedData?> = arrayOfNulls(size)
        }
    }
}