package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable

data class LobbyEvent(
        var eventType: String? = null,   //The type of event that was triggered
        var summonerId: String? = null,  //The summoner that triggered the event
        var timestamp: String? = null    //Timestamp from the event
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(eventType)
        writeString(summonerId)
        writeString(timestamp)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LobbyEvent> = object : Parcelable.Creator<LobbyEvent> {
            override fun createFromParcel(source: Parcel): LobbyEvent = LobbyEvent(source)
            override fun newArray(size: Int): Array<LobbyEvent?> = arrayOfNulls(size)
        }
    }
}