package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class MatchParticipantFrame(
        var totalGold: Int? = null,
        var teamScore: Int? = null,
        var participantId: Int? = null,
        var level: Int? = null,
        var currentGold: Int? = null,
        var minionsKilled: Int? = null,
        var dominionScore: Int? = null,
        var position: MatchPosition? = null,
        var xp: Int? = null,
        var jungleMinionsKilled: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<MatchPosition>(MatchPosition::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(totalGold)
        writeValue(teamScore)
        writeValue(participantId)
        writeValue(level)
        writeValue(currentGold)
        writeValue(minionsKilled)
        writeValue(dominionScore)
        writeParcelable(position, 0)
        writeValue(xp)
        writeValue(jungleMinionsKilled)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantFrame> = object : Parcelable.Creator<MatchParticipantFrame> {
            override fun createFromParcel(source: Parcel): MatchParticipantFrame = MatchParticipantFrame(source)
            override fun newArray(size: Int): Array<MatchParticipantFrame?> = arrayOfNulls(size)
        }
    }
}