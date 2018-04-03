package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MasteryTreeList(
        var masteryTreeItems: List<MasteryTreeItem>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(MasteryTreeItem.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(masteryTreeItems)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MasteryTreeList> = object : Parcelable.Creator<MasteryTreeList> {
            override fun createFromParcel(source: Parcel): MasteryTreeList = MasteryTreeList(source)
            override fun newArray(size: Int): Array<MasteryTreeList?> = arrayOfNulls(size)
        }
    }
}