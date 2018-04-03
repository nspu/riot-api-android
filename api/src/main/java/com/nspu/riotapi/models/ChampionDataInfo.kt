package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionDataInfo(
        var difficulty: Int? = null,
        var attack: Int? = null,
        var defense: Int? = null,
        var magic: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(difficulty)
        parcel.writeValue(attack)
        parcel.writeValue(defense)
        parcel.writeValue(magic)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChampionDataInfo> {
        override fun createFromParcel(parcel: Parcel): ChampionDataInfo {
            return ChampionDataInfo(parcel)
        }

        override fun newArray(size: Int): Array<ChampionDataInfo?> {
            return arrayOfNulls(size)
        }
    }

}