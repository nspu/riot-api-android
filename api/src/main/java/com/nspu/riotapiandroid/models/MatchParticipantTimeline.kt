package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchParticipantTimeline(
        var lane: String? = null,
        var participantId: Int? = null,
        var csDiffPerMinDeltas: Map<String, Double>? = null,
        var goldPerMinDeltas: Map<String, Double>? = null,
        var xpDiffPerMinDeltas: Map<String, Double>? = null,
        var creepsPerMinDeltas: Map<String, Double>? = null,
        var xpPerMinDeltas: Map<String, Double>? = null,
        var role: String? = null,
        var damageTakenDiffPerMinDeltas: Map<String, Double>? = null,
        var damageTakenPerMinDeltas: Map<String, Double>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readString(),
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) },
            mapOf<String, Double>().apply { source.readMap(this, Map::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(lane)
        writeValue(participantId)
        writeMap(csDiffPerMinDeltas)
        writeMap(goldPerMinDeltas)
        writeMap(xpDiffPerMinDeltas)
        writeMap(creepsPerMinDeltas)
        writeMap(xpPerMinDeltas)
        writeString(role)
        writeMap(damageTakenDiffPerMinDeltas)
        writeMap(damageTakenPerMinDeltas)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantTimeline> = object : Parcelable.Creator<MatchParticipantTimeline> {
            override fun createFromParcel(source: Parcel): MatchParticipantTimeline = MatchParticipantTimeline(source)
            override fun newArray(size: Int): Array<MatchParticipantTimeline?> = arrayOfNulls(size)
        }
    }
}