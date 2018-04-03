package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionRecommandedBlockItem(var count: Int? = null,
                                        var id: Int? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(count)
        writeValue(id)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionRecommandedBlockItem> = object : Parcelable.Creator<ChampionRecommandedBlockItem> {
            override fun createFromParcel(source: Parcel): ChampionRecommandedBlockItem = ChampionRecommandedBlockItem(source)
            override fun newArray(size: Int): Array<ChampionRecommandedBlockItem?> = arrayOfNulls(size)
        }
    }
}