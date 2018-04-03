package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class MasteryTree(
        var Resolve: List<MasteryTreeList>? = null,
        var Defense: List<MasteryTreeList>? = null,
        var Utility: List<MasteryTreeList>? = null,
        var Offense: List<MasteryTreeList>? = null,
        var Ferocity: List<MasteryTreeList>? = null,
        var Cunning: List<MasteryTreeList>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR),
            source.createTypedArrayList(MasteryTreeList.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(Resolve)
        writeTypedList(Defense)
        writeTypedList(Utility)
        writeTypedList(Offense)
        writeTypedList(Ferocity)
        writeTypedList(Cunning)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MasteryTree> = object : Parcelable.Creator<MasteryTree> {
            override fun createFromParcel(source: Parcel): MasteryTree = MasteryTree(source)
            override fun newArray(size: Int): Array<MasteryTree?> = arrayOfNulls(size)
        }
    }
}