package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchReference(
        var lane: String? = null,
        var gameId: Long? = null,
        var champion: Int? = null,
        var platformId: String? = null,
        var season: Int? = null,
        var queue: Int? = null,
        var role: String? = null,
        var timestamp: Long? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(lane)
        writeValue(gameId)
        writeValue(champion)
        writeString(platformId)
        writeValue(season)
        writeValue(queue)
        writeString(role)
        writeValue(timestamp)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchReference> = object : Parcelable.Creator<MatchReference> {
            override fun createFromParcel(source: Parcel): MatchReference = MatchReference(source)
            override fun newArray(size: Int): Array<MatchReference?> = arrayOfNulls(size)
        }
    }
}