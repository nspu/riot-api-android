package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class TournamentCode(
        var map: String? = null, // 	The game map for the tournament code game
        var code: String? = null, // 	The tournament code.
        var spectators: String? = null, // 	The spectator mode for the tournament code game.
        var region: String? = null, // 	The tournament code's region. (Legal values: BR, EUNE, EUW, JP, LAN, LAS, NA, OCE, PBE, RU, TR)
        var providerId: Int? = null, // 	The provider's ID.
        var teamSize: Int? = null, // 	The team size for the tournament code game.
        var participants: Set<Long>? = null,
        var pickType: String? = null, // 	The pick mode for tournament code game.
        var tournamentId: Int? = null, // 	The tournament's ID.
        var lobbyName: String? = null, // 	The lobby name for the tournament code game.
        var password: String? = null, // 	The password for the tournament code game.
        var id: Int? = null, // 	The tournament code's ID.
        var metaData: String? = null // 	The metadata for tournament code.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            hashSetOf<Long>().apply { source.readValue(Set::class.java.classLoader) },
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(map)
        writeString(code)
        writeString(spectators)
        writeString(region)
        writeValue(providerId)
        writeValue(teamSize)
        writeValue(participants)
        writeString(pickType)
        writeValue(tournamentId)
        writeString(lobbyName)
        writeString(password)
        writeValue(id)
        writeString(metaData)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TournamentCode> = object : Parcelable.Creator<TournamentCode> {
            override fun createFromParcel(source: Parcel): TournamentCode = TournamentCode(source)
            override fun newArray(size: Int): Array<TournamentCode?> = arrayOfNulls(size)
        }
    }
}