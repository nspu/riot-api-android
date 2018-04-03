package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class Translation(
        var locale: String? = null,
        var content: String? = null,
        var updated_at: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(locale)
        writeString(content)
        writeString(updated_at)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Translation> = object : Parcelable.Creator<Translation> {
            override fun createFromParcel(source: Parcel): Translation = Translation(source)
            override fun newArray(size: Int): Array<Translation?> = arrayOfNulls(size)
        }
    }
}