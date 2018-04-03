package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class SpectatorBannedChampion(
        var pickTurn: Int? = null,// 	The turn during which the champion was banned
        var championId: Long? = null,// 	The ID of the banned champion
        var teamId: Long? = null// 	The ID of the team that banned the champion
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(pickTurn)
        writeValue(championId)
        writeValue(teamId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorBannedChampion> = object : Parcelable.Creator<SpectatorBannedChampion> {
            override fun createFromParcel(source: Parcel): SpectatorBannedChampion = SpectatorBannedChampion(source)
            override fun newArray(size: Int): Array<SpectatorBannedChampion?> = arrayOfNulls(size)
        }
    }
}
