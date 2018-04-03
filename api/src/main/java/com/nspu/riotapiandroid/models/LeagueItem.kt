package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class LeagueItem(
        var rank: String? = null,
        var hotStreak: Boolean? = null,
        var miniSeries: MiniSeries? = null,
        var wins: Int? = null,
        var veteran: Boolean? = null,
        var losses: Int? = null,
        var freshBlood: Boolean? = null,
        var playerOrTeamName: String? = null,
        var inactive: Boolean? = null,
        var playerOrTeamId: String? = null,
        var leaguePoints: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readParcelable<MiniSeries>(MiniSeries::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(rank)
        writeValue(hotStreak)
        writeParcelable(miniSeries, 0)
        writeValue(wins)
        writeValue(veteran)
        writeValue(losses)
        writeValue(freshBlood)
        writeString(playerOrTeamName)
        writeValue(inactive)
        writeString(playerOrTeamId)
        writeValue(leaguePoints)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LeagueItem> = object : Parcelable.Creator<LeagueItem> {
            override fun createFromParcel(source: Parcel): LeagueItem = LeagueItem(source)
            override fun newArray(size: Int): Array<LeagueItem?> = arrayOfNulls(size)
        }
    }
}