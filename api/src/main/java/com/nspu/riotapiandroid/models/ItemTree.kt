package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class ItemTree(
        var header: String? = null,
        var tags: List<String>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(header)
        writeStringList(tags)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemTree> = object : Parcelable.Creator<ItemTree> {
            override fun createFromParcel(source: Parcel): ItemTree = ItemTree(source)
            override fun newArray(size: Int): Array<ItemTree?> = arrayOfNulls(size)
        }
    }
}