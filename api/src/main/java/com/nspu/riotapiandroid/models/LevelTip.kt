package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class LevelTip(var effect: List<String>? = null,
                    var label: List<String>? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.createStringArrayList(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeStringList(effect)
        writeStringList(label)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LevelTip> = object : Parcelable.Creator<LevelTip> {
            override fun createFromParcel(source: Parcel): LevelTip = LevelTip(source)
            override fun newArray(size: Int): Array<LevelTip?> = arrayOfNulls(size)
        }
    }
}