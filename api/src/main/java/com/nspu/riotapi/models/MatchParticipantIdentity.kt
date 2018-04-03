package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class MatchParticipantIdentity(
        var player: MatchPlayer? = null,
        var participantId: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<MatchPlayer>(MatchPlayer::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(player, 0)
        writeValue(participantId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantIdentity> = object : Parcelable.Creator<MatchParticipantIdentity> {
            override fun createFromParcel(source: Parcel): MatchParticipantIdentity = MatchParticipantIdentity(source)
            override fun newArray(size: Int): Array<MatchParticipantIdentity?> = arrayOfNulls(size)
        }
    }
}