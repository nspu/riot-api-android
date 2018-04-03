package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ItemList(
        var data: Map<String, Item>? = null,
        var version: String? = null,
        var tree: List<ItemTree>? = null,
        var groups: List<ItemGroup>? = null,
        var type: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            hashMapOf<String, Item>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readString(),
            source.createTypedArrayList(ItemTree.CREATOR),
            source.createTypedArrayList(ItemGroup.CREATOR),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeMap(data)
        writeString(version)
        writeTypedList(tree)
        writeTypedList(groups)
        writeString(type)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemList> = object : Parcelable.Creator<ItemList> {
            override fun createFromParcel(source: Parcel): ItemList = ItemList(source)
            override fun newArray(size: Int): Array<ItemList?> = arrayOfNulls(size)
        }
    }
}