package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable

class TournamentCodeUpdateParameters(
        val spectatorType: String? = null,    //The spectator type (Legal values: NONE, LOBBYONLY, ALL)
        val pickType: String? = null,    //The pick type (Legal values: BLIND_PICK, DRAFT_MODE, ALL_RANDOM, TOURNAMENT_DRAFT)
        val allowedSummonerIds: Set<Long>? = null,//Optional list of participants in order to validate the players eligible to join the lobby. NOTE: We currently do not enforce participants at the team level, but rather the aggregate of teamOne and teamTwo. We may add the ability to enforce at the team level in the future.
        val mapType: String? = null    //The map type (Legal values: SUMMONERS_RIFT, TWISTED_TREELINE, HOWLING_ABYSS)
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            hashSetOf<Long>().apply { source.readValue(Set::class.java.classLoader) },
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(spectatorType)
        writeString(pickType)
        writeValue(allowedSummonerIds)
        writeString(mapType)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TournamentCodeUpdateParameters> = object : Parcelable.Creator<TournamentCodeUpdateParameters> {
            override fun createFromParcel(source: Parcel): TournamentCodeUpdateParameters = TournamentCodeUpdateParameters(source)
            override fun newArray(size: Int): Array<TournamentCodeUpdateParameters?> = arrayOfNulls(size)
        }
    }
}