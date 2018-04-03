package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


class Match(
        var seasonId: Int? = null,
        var queueId: Int? = null,
        var gameId: Long? = null,
        var participantIdentities: List<MatchParticipantIdentity>? = null,
        var gameVersion: String? = null,
        var platformId: String? = null,
        var gameMode: String? = null,
        var mapId: Int? = null,
        var gameType: String? = null,
        var teams: List<MatchTeamStats>? = null,
        var participants: List<MatchParticipant>? = null,
        var gameDuration: Long? = null,
        var gameCreation: Long? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.createTypedArrayList(MatchParticipantIdentity.CREATOR),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.createTypedArrayList(MatchTeamStats.CREATOR),
            source.createTypedArrayList(MatchParticipant.CREATOR),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(seasonId)
        writeValue(queueId)
        writeValue(gameId)
        writeTypedList(participantIdentities)
        writeString(gameVersion)
        writeString(platformId)
        writeString(gameMode)
        writeValue(mapId)
        writeString(gameType)
        writeTypedList(teams)
        writeTypedList(participants)
        writeValue(gameDuration)
        writeValue(gameCreation)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Match> = object : Parcelable.Creator<Match> {
            override fun createFromParcel(source: Parcel): Match = Match(source)
            override fun newArray(size: Int): Array<Match?> = arrayOfNulls(size)
        }
    }
}