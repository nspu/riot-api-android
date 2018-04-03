package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MetaData(
        var tier: String? = null,
        var type: String? = null,
        var isRune: Boolean? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(tier)
        writeString(type)
        writeValue(isRune)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MetaData> = object : Parcelable.Creator<MetaData> {
            override fun createFromParcel(source: Parcel): MetaData = MetaData(source)
            override fun newArray(size: Int): Array<MetaData?> = arrayOfNulls(size)
        }
    }
}