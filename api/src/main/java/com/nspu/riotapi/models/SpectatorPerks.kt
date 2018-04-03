package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class SpectatorPerks(
        var perkStyle: Long? = null, //	Primary runes path
        var perkIds: List<Long>? = null,    //IDs of the perks/runes assigned.
        var perkSubStyle: Long? = null//Secondary runes path
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            ArrayList<Long>().apply { source.readList(this, Long::class.java.classLoader) },
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(perkStyle)
        writeList(perkIds)
        writeValue(perkSubStyle)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorPerks> = object : Parcelable.Creator<SpectatorPerks> {
            override fun createFromParcel(source: Parcel): SpectatorPerks = SpectatorPerks(source)
            override fun newArray(size: Int): Array<SpectatorPerks?> = arrayOfNulls(size)
        }
    }
}