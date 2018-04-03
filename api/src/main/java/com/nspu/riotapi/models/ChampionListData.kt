package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable

/**
 *
 */
data class ChampionListData(
        var keys: Map<String, String>? = null,
        var data: Map<String, ChampionData>? = null,
        var version: String? = null,
        var type: String? = null,
        var format: String? = null) : Parcelable {


    constructor(parcel: Parcel) : this(
            hashMapOf<String, String>().apply { parcel.readMap(this, Map::class.java.classLoader) },
            hashMapOf<String, ChampionData>().apply { parcel.readMap(this, Map::class.java.classLoader) },
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeMap(keys)
        parcel.writeMap(data)
        parcel.writeString(version)
        parcel.writeString(type)
        parcel.writeString(format)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChampionListData> {
        override fun createFromParcel(parcel: Parcel): ChampionListData = ChampionListData(parcel)
        override fun newArray(size: Int): Array<ChampionListData?> = arrayOfNulls(size)
    }

}