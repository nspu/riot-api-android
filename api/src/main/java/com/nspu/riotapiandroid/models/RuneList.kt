package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class RuneList(
        var data: Map<String, Rune>? = null,
        var version: String? = null,
        var type: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            hashMapOf<String, Rune>().apply { source.readMap(this, Map::class.java.classLoader) },
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
        val CREATOR: Parcelable.Creator<RuneList> = object : Parcelable.Creator<RuneList> {
            override fun createFromParcel(source: Parcel): RuneList = RuneList(source)
            override fun newArray(size: Int): Array<RuneList?> = arrayOfNulls(size)
        }
    }
}