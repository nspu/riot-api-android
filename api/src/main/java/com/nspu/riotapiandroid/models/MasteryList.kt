package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MasteryList(var data: Map<String, Mastery>? = null,
                       var version: String? = null,
                       var tree: MasteryTree? = null,
                       var type: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            emptyMap<String, Mastery>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readString(),
            source.readParcelable<MasteryTree>(MasteryTree::class.java.classLoader),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeMap(data)
        writeString(version)
        writeParcelable(tree, 0)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MasteryList> = object : Parcelable.Creator<MasteryList> {
            override fun createFromParcel(source: Parcel): MasteryList = MasteryList(source)
            override fun newArray(size: Int): Array<MasteryList?> = arrayOfNulls(size)
        }
    }
}