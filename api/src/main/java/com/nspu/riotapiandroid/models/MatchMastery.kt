package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchMastery(
        var masteryId: Int? = null,
        var rank: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(masteryId)
        writeValue(rank)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchMastery> = object : Parcelable.Creator<MatchMastery> {
            override fun createFromParcel(source: Parcel): MatchMastery = MatchMastery(source)
            override fun newArray(size: Int): Array<MatchMastery?> = arrayOfNulls(size)
        }
    }
}