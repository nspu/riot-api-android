package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ReforgedRuneSlot(
        var runes: List<ReforgedRune>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(ReforgedRune.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(runes)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ReforgedRuneSlot> = object : Parcelable.Creator<ReforgedRuneSlot> {
            override fun createFromParcel(source: Parcel): ReforgedRuneSlot = ReforgedRuneSlot(source)
            override fun newArray(size: Int): Array<ReforgedRuneSlot?> = arrayOfNulls(size)
        }
    }
}