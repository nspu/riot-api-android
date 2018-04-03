package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class LeagueList(
        var leagueId: String? = null,
        var tier: String? = null,
        var entries: List<LeagueItem>? = null,
        var queue: String? = null,
        var name: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.createTypedArrayList(LeagueItem.CREATOR),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(leagueId)
        writeString(tier)
        writeTypedList(entries)
        writeString(queue)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<LeagueList> = object : Parcelable.Creator<LeagueList> {
            override fun createFromParcel(source: Parcel): LeagueList = LeagueList(source)
            override fun newArray(size: Int): Array<LeagueList?> = arrayOfNulls(size)
        }
    }
}