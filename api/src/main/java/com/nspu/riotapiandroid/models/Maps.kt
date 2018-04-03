package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class Maps(
        var data: Map<String, MapDetails>? = null,
        var version: String? = null,
        var type: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            emptyMap<String, MapDetails>().apply { source.readMap(this, Map::class.java.classLoader) },
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
        val CREATOR: Parcelable.Creator<Maps> = object : Parcelable.Creator<Maps> {
            override fun createFromParcel(source: Parcel): Maps = Maps(source)
            override fun newArray(size: Int): Array<Maps?> = arrayOfNulls(size)
        }
    }
}