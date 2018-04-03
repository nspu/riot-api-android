package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchPosition(
        var y: Int? = null,
        var x: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(y)
        writeValue(x)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchPosition> = object : Parcelable.Creator<MatchPosition> {
            override fun createFromParcel(source: Parcel): MatchPosition = MatchPosition(source)
            override fun newArray(size: Int): Array<MatchPosition?> = arrayOfNulls(size)
        }
    }
}