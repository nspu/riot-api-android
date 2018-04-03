package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


class ChampionMastery(
        var chestGranted: Boolean? = null,    //Is chest granted for this champion or not in current season.
        var championLevel: Int? = null,    //ChampionData level for specified player and champion combination.
        var championPoints: Int? = null, //	Total number of champion points for this player and champion combination - they are used to determine championLevel.
        var championId: Long? = null, //	ChampionData ID for this entry.
        var playerId: Long? = null, //	Player ID for this entry.
        var championPointsUntilNextLevel: Int? = null, //	long 	Number of po:Int? = null,s needed to achieve next level. Zero if player reached maximum champion level for this champion.
        var tokensEarned: Int? = null,// 	The token earned for this champion to levelup.
        var championPointsSinceLastLevel: Int? = null, //long 	Number of points earned since current level has been achieved.
        var lastPlayTime: Long? = null    //Last time this champion was played by this player - in Unix milliseconds time format.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(chestGranted)
        writeValue(championLevel)
        writeValue(championPoints)
        writeValue(championId)
        writeValue(playerId)
        writeValue(championPointsUntilNextLevel)
        writeValue(tokensEarned)
        writeValue(championPointsSinceLastLevel)
        writeValue(lastPlayTime)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionMastery> = object : Parcelable.Creator<ChampionMastery> {
            override fun createFromParcel(source: Parcel): ChampionMastery = ChampionMastery(source)
            override fun newArray(size: Int): Array<ChampionMastery?> = arrayOfNulls(size)
        }
    }
}