package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionInfo(
        var rankedPlayEnabled: Boolean? = null, // 	Ranked play enabled flag.
        var botEnabled: Boolean? = null, // 	Bot enabled flag (for custom games).
        var botMmEnabled: Boolean? = null, // 	Bot Match Made enabled flag (for Co-op vs. AI games).
        var active: Boolean? = null, // 	Indicates if the champion is active.
        var freeToPlay: Boolean? = null, // 	Indicates if the champion is free to play. Free to play championData are rotated periodically.
        var id: Long? = null // 	Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(rankedPlayEnabled)
        writeValue(botEnabled)
        writeValue(botMmEnabled)
        writeValue(active)
        writeValue(freeToPlay)
        writeValue(id)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionInfo> = object : Parcelable.Creator<ChampionInfo> {
            override fun createFromParcel(source: Parcel): ChampionInfo = ChampionInfo(source)
            override fun newArray(size: Int): Array<ChampionInfo?> = arrayOfNulls(size)
        }
    }
}