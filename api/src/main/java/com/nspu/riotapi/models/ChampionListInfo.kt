package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionListInfo(
        var champions: List<ChampionInfo>? = null    //The collection of champion information.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(ChampionInfo.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(champions)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionListInfo> = object : Parcelable.Creator<ChampionListInfo> {
            override fun createFromParcel(source: Parcel): ChampionListInfo = ChampionListInfo(source)
            override fun newArray(size: Int): Array<ChampionListInfo?> = arrayOfNulls(size)
        }
    }
}