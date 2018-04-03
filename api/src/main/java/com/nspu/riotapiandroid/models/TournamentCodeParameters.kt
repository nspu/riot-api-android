package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Parameter for create codes
 *
 * @property spectatorType The spectator type of the game. (Legal values: NONE, LOBBYONLY, ALL)
 * @property teamSize The team size of the game. Valid values are 1-5.
 * @property pickType The pick type of the game. (Legal values: BLIND_PICK, DRAFT_MODE, ALL_RANDOM, TOURNAMENT_DRAFT)
 * @property allowedSummonerIds Optional list of participants in order to validate the players eligible to join the lobby. NOTE: We currently do not enforce participants at the team level, but rather the aggregate of teamOne and teamTwo. We may add the ability to enforce at the team level in the future.
 * @property mapType The map type of the game. (Legal values: SUMMONERS_RIFT, TWISTED_TREELINE, HOWLING_ABYSS)
 * @property metadata Optional string that may contain any data in any format, if specified at all. Used to denote any custom information about the game.
 */
data class TournamentCodeParameters(
        var allowedSummonerIds: List<Long>? = null,
        var mapType: String? = null,
        var metadata: String? = null,
        var pickType: String? = null,
        var spectatorType: String? = null,
        var teamSize: Int? = 0) : Parcelable {
    constructor(source: Parcel) : this(
            ArrayList<Long>().apply { source.readList(this, Long::class.java.classLoader) },
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(allowedSummonerIds)
        writeString(mapType)
        writeString(metadata)
        writeString(pickType)
        writeString(spectatorType)
        writeValue(teamSize)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TournamentCodeParameters> = object : Parcelable.Creator<TournamentCodeParameters> {
            override fun createFromParcel(source: Parcel): TournamentCodeParameters = TournamentCodeParameters(source)
            override fun newArray(size: Int): Array<TournamentCodeParameters?> = arrayOfNulls(size)
        }
    }
}