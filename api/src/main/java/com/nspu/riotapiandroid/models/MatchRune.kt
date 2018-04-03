package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchRune(
        var runeId: Int? = null,
        var rank: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(runeId)
        writeValue(rank)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchRune> = object : Parcelable.Creator<MatchRune> {
            override fun createFromParcel(source: Parcel): MatchRune = MatchRune(source)
            override fun newArray(size: Int): Array<MatchRune?> = arrayOfNulls(size)
        }
    }
}