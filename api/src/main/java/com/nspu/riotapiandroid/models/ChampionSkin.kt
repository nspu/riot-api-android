package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionSkin(
        var num: Int? = null,
        var name: String? = null,
        var id: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(num)
        writeString(name)
        writeValue(id)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionSkin> = object : Parcelable.Creator<ChampionSkin> {
            override fun createFromParcel(source: Parcel): ChampionSkin = ChampionSkin(source)
            override fun newArray(size: Int): Array<ChampionSkin?> = arrayOfNulls(size)
        }
    }
}