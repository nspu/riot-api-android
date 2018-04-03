package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchTeamStats(
        var firstDragon: Boolean? = null,
        var firstInhibitor: Boolean? = null,
        var bans: List<MatchTeamBans>? = null,
        var baronKills: Int? = null,
        var firstRiftHerald: Boolean? = null,
        var firstBaron: Boolean? = null,
        var riftHeraldKills: Int? = null,
        var firstBlood: Boolean? = null,
        var teamId: Int? = null,
        var firstTower: Boolean? = null,
        var vilemawKills: Int? = null,
        var inhibitorKills: Int? = null,
        var towerKills: Int? = null,
        var dominionVictoryScore: Int? = null,
        var win: String? = null,
        var dragonKills: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.createTypedArrayList(MatchTeamBans.CREATOR),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(firstDragon)
        writeValue(firstInhibitor)
        writeTypedList(bans)
        writeValue(baronKills)
        writeValue(firstRiftHerald)
        writeValue(firstBaron)
        writeValue(riftHeraldKills)
        writeValue(firstBlood)
        writeValue(teamId)
        writeValue(firstTower)
        writeValue(vilemawKills)
        writeValue(inhibitorKills)
        writeValue(towerKills)
        writeValue(dominionVictoryScore)
        writeString(win)
        writeValue(dragonKills)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchTeamStats> = object : Parcelable.Creator<MatchTeamStats> {
            override fun createFromParcel(source: Parcel): MatchTeamStats = MatchTeamStats(source)
            override fun newArray(size: Int): Array<MatchTeamStats?> = arrayOfNulls(size)
        }
    }
}