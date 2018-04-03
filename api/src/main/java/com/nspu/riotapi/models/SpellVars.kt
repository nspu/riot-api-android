package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class SpellVars(
        var ranksWith: String? = null,
        var dyn: String? = null,
        var link: String? = null,
        var coeff: List<Double>? = null,
        var key: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) },
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(ranksWith)
        writeString(dyn)
        writeString(link)
        writeList(coeff)
        writeString(key)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpellVars> = object : Parcelable.Creator<SpellVars> {
            override fun createFromParcel(source: Parcel): SpellVars = SpellVars(source)
            override fun newArray(size: Int): Array<SpellVars?> = arrayOfNulls(size)
        }
    }
}