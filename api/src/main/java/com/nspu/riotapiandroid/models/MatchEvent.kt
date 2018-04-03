package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchEvent(
        var eventType: String? = null,
        var towerType: String? = null,
        var teamId: Int? = null,
        var ascendedType: String? = null,
        var killerId: Int? = null,
        var levelUpType: String? = null,
        var pointCaptured: String? = null,
        var assistingParticipantIds: List<Int>? = null,
        var wardType: String? = null,
        var monsterType: String? = null,
        var type: String? = null,    //(Legal values: CHAMPION_KILL, WARD_PLACED, WARD_KILL, BUILDING_KILL, ELITE_MONSTER_KILL, ITEM_PURCHASED, ITEM_SOLD, ITEM_DESTROYED, ITEM_UNDO, SKILL_LEVEL_UP, ASCENDED_EVENT, CAPTURE_POINT, PORO_KING_SUMMON)
        var skillSlot: Int? = null,
        var victimId: Int? = null,
        var timestamp: Long? = null,
        var afterId: Int? = null,
        var monsterSubType: String? = null,
        var laneType: String? = null,
        var itemId: Int? = null,
        var participantId: Int? = null,
        var buildingType: String? = null,
        var creatorId: Int? = null,
        var position: MatchPosition? = null,
        var beforeId: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<MatchPosition>(MatchPosition::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(eventType)
        writeString(towerType)
        writeValue(teamId)
        writeString(ascendedType)
        writeValue(killerId)
        writeString(levelUpType)
        writeString(pointCaptured)
        writeList(assistingParticipantIds)
        writeString(wardType)
        writeString(monsterType)
        writeString(type)
        writeValue(skillSlot)
        writeValue(victimId)
        writeValue(timestamp)
        writeValue(afterId)
        writeString(monsterSubType)
        writeString(laneType)
        writeValue(itemId)
        writeValue(participantId)
        writeString(buildingType)
        writeValue(creatorId)
        writeParcelable(position, 0)
        writeValue(beforeId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchEvent> = object : Parcelable.Creator<MatchEvent> {
            override fun createFromParcel(source: Parcel): MatchEvent = MatchEvent(source)
            override fun newArray(size: Int): Array<MatchEvent?> = arrayOfNulls(size)
        }
    }
}