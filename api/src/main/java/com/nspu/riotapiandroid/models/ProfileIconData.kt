package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class ProfileIconData(
        var data: Map<String, ProfileIconDetails>? = null,
        var version: String? = null,
        var type: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            hashMapOf<String, ProfileIconDetails>().apply { source.readMap(this, Map::class.java.classLoader) },
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
        val CREATOR: Parcelable.Creator<ProfileIconData> = object : Parcelable.Creator<ProfileIconData> {
            override fun createFromParcel(source: Parcel): ProfileIconData = ProfileIconData(source)
            override fun newArray(size: Int): Array<ProfileIconData?> = arrayOfNulls(size)
        }
    }
}