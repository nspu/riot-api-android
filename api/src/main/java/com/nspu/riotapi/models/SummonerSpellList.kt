package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class SummonerSpellList(
        var data: Map<String, SummonerSpell>? = null,
        var version: String? = null,
        var type: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            hashMapOf<String, SummonerSpell>().apply { source.readMap(this, Map::class.java.classLoader) },
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
        val CREATOR: Parcelable.Creator<SummonerSpellList> = object : Parcelable.Creator<SummonerSpellList> {
            override fun createFromParcel(source: Parcel): SummonerSpellList = SummonerSpellList(source)
            override fun newArray(size: Int): Array<SummonerSpellList?> = arrayOfNulls(size)
        }
    }
}